package vttp2022.workshop21.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.workshop21.model.Comment;
import vttp2022.workshop21.model.Game;
import vttp2022.workshop21.repositories.GameRepository;

@Controller
@RequestMapping(path = "/", produces= MediaType.TEXT_HTML_VALUE)
public class gameController {

    @Autowired
    private GameRepository gameRepo;


    @GetMapping("/game/{gid}")
    public String showGame(@PathVariable(name="gid") String gid, Model model){
        Optional<Game> opt = gameRepo.getGameByGid(Integer.parseInt(gid));
        Game game = new Game();
        if (!opt.isEmpty()){
            game = opt.get();
        }
        List<Comment> commentList = gameRepo.getCommentsByGid(Integer.parseInt(gid),5);

        model.addAttribute("game", game);
        model.addAttribute("commentList", commentList);
        
        return "showGame";
    }


}
