package com.techelevator.dao;

import com.techelevator.model.Post;
<<<<<<< HEAD

public interface PostDao {

    Post createPost(Post post, int userId);
    Post getPostById(int id);

    void deletePostById(int id);

    Post updatePost(Post post);
=======
import com.techelevator.model.User;

import java.util.List;

public interface PostDao {
    List<Post> getAllPosts();

    Post createPost(Post post, int userId);

    Post getPostById(int id);

    boolean hasUserLikedPostById(int postId, String authorName);

    int deletePostById(int id);

    Post updatePost(Post post);

    void addLike(Post post, User author);

    void removeLike(Post post, User author);
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd
}
