package com.techelevator.model;

import java.util.Date;

public class Post {

    private int post_id;
    private String caption;
    private String postCreator;

    private int totalLikes;
    /** True if the current user has liked the post. */
    private boolean liked;

    private Date createdOn;


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

    public Post(int post_id, String caption, String postCreator, int totalLikes) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
    }

    public Post(int post_id, String caption, String postCreator, int totalLikes, boolean isLiked, Date createdOn) {
        this.id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
        this.liked = isLiked;
        this.createdOn = createdOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;

    }

    public int getId() {
        return post_id;
    }

    public void setId(int id) {
        this.post_id = id;
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


    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

}
