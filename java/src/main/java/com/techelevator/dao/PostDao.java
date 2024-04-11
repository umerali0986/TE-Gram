package com.techelevator.dao;

import com.techelevator.model.Post;

public interface PostDao {

    Post createPost(Post post, int userId);
    Post getPostById(int id);

    void deletePostById(int id);

    Post updatePost(Post post);
}
