package vttp2022.workshop21.repositories;

public interface Queries {
    //can have multiple ?s. Ordered from left to right starting from 1
    public static final String SQL_SELECT_GAME_BY_GID = "select * from game where gid = ?";

    public static final String SQL_SELECT_COMMENT_BY_GID = "select * from comment where gid = ? limit ? offset ?";

}
