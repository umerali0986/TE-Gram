package com.techelevator.model;

import java.util.Date;

public class Post {

    private int post_id;
    private String caption;
    private String postCreator;

    private int totalLikes;
    private int totalFavorites;
    /** True if the current user has liked the post. */
    private boolean liked;

    private boolean favorite;

    private boolean isPrivate;



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

    public Post(int post_id, String caption, String postCreator, int totalLikes, int totalFavorites, Date createdOn) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
        this.totalFavorites = totalFavorites;
    }

    public Post(int post_id, String caption, String postCreator, int totalLikes, boolean isLiked, Date createdOn, boolean favorite, int totalFavorites) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
        this.liked = isLiked;
        this.createdOn = createdOn;
        this.favorite = favorite;
        this.totalFavorites = totalFavorites;
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

    public int getTotalFavorites() { return totalFavorites; }

    public void setTotalFavorites(int totalFavorites) { this.totalFavorites = totalFavorites; }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }
}
