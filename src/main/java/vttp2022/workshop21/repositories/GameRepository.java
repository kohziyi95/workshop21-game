package vttp2022.workshop21.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.workshop21.model.Comment;
import vttp2022.workshop21.model.Game;

import static vttp2022.workshop21.repositories.Queries.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {
    
    @Autowired
    private JdbcTemplate template;
    public List<Comment> getCommentsByGid(Integer gid){
        return getCommentsByGid(gid, 1000 , 0 );
    }

    public List<Comment> getCommentsByGid(Integer gid, Integer limit){
        return getCommentsByGid(gid, limit , 0 );
    }    
    
    public List<Comment> getCommentsByGid(Integer gid, Integer limit, Integer offset){
        final SqlRowSet result = template.queryForRowSet(
            SQL_SELECT_COMMENT_BY_GID, gid, limit, offset
        );

        // if (!result.next())
        //     return null;
        
        List<Comment> commentList= new ArrayList<>();
        while (result.next()){
            Comment c = Comment.create(result);
            commentList.add(c);
        }

        return commentList;
    }

    public Optional<Game> getGameByGid(Integer queryGid){
        final SqlRowSet result = template.queryForRowSet(
            SQL_SELECT_GAME_BY_GID, queryGid 
        );

        if (!result.next())
            return Optional.empty();


        Game g = Game.create(result);

        return Optional.of(g);
    }
}
