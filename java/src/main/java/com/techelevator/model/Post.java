package com.techelevator.model;

public class Post {

    private int post_id;
    private String caption;
    private String postCreator;
<<<<<<< HEAD
=======
    private int totalLikes;
    /** True if the current user has liked the post. */
    private boolean liked;
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd

    public Post() {
    }

<<<<<<< HEAD
    public Post(int post_id, String caption, String postCreator) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
    }

    public Post(String caption, String postCreator) {
        this.caption = caption;
        this.postCreator = postCreator;
=======
    public Post(int post_id, String caption, String postCreator, int totalLikes) {
        this.post_id = post_id;
        this.caption = caption;
        this.postCreator = postCreator;
        this. totalLikes = totalLikes;
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd
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
<<<<<<< HEAD
=======

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
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd
}
