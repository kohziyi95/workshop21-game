package vttp2022.workshop21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private String commentId;
    private String user;
    private Integer rating;
    private String commentText;
    private int gid;

    public static Comment create(SqlRowSet result){
        Comment c = new Comment();
        c.setCommentId(result.getString("c_id"));
        c.setUser(result.getString("user"));
        c.setRating(result.getInt("rating"));
        c.setCommentText(result.getString("c_text"));
        c.setGid(result.getInt("gid"));
        return c;
    }

    public String getCommentId() {
        return commentId;
    }
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getCommentText() {
        return commentText;
    }
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }

    
}
