package com.techelevator.model;

import java.util.Date;

public class Comment {

    private int commentId;
    private String text;
    private User author;
    private Date createdOn;

    public Comment() {
    }

    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
