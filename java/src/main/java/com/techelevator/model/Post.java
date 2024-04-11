package com.techelevator.model;

public class Post {

    private int post_id;
    private String caption;
    private String postCreator;

    public Post() {
    }

    public Post(int post_id, String caption, String postCreator) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
    }

    public Post(String caption, String postCreator) {
        this.caption = caption;
        this.postCreator = postCreator;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPostCreator() {
        return postCreator;
    }

    public void setPostCreator(String postCreator) {
        this.postCreator = postCreator;
    }
}
