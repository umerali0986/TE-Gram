package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class PostWithImage extends Post {

    private Image image;
    private List<Comment> comments;

    public PostWithImage(Post post, Image image) {
        this(post, image, new ArrayList<>());
    }

    public PostWithImage(Post post, Image image, List<Comment> comments) {
        super(post.getId(), post.getCaption(), post.getPostCreator(), post.getTotalLikes(), post.isLiked(), post.getCreatedOn(), post.isFavorite());
        this.image = image;
        this.comments = comments;
    }

    public Image getImage() {
        return image;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
