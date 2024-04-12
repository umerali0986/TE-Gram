package com.techelevator.dao;

import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import com.techelevator.model.User;

import java.util.List;

public interface CommentDao {

    Comment createComment(Post post, User author, String text);

    List<Comment> getCommentsByPostId(int postId);

    int deleteCommentById(int id);

    Comment updateComment(Comment post);
}
