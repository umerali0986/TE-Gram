package com.techelevator.dao;

import com.techelevator.model.Post;
import com.techelevator.model.User;

import java.util.List;

public interface PostDao {
    List<Post> getAllPosts();

    Post createPost(Post post, int userId);

    Post getPostById(int id);

    List<Post> getPostsByCreator(String creator);

    boolean hasUserLikedPostById(int postId, String authorName);

    int deletePostById(int id);
    int deleteCommentById(int comment_id);

    Post updatePost(Post post);

    void addLike(Post post, User author);

    void removeLike(Post post, User author);
}
