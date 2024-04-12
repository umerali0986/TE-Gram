package com.techelevator.model;

public class Post {

    private int post_id;
    private String caption;
    private String postCreator;
    private int totalLikes;
    /** True if the current user has liked the post. */
    private boolean liked;

    public Post() {
    }

    public Post(int post_id, String caption, String postCreator, int totalLikes) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
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
