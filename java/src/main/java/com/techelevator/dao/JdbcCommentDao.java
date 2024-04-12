package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Comment;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class JdbcCommentDao implements CommentDao {

    @Autowired
    private JdbcUserDao jdbcUserDao;

    private final JdbcTemplate jdbcTemplate;

    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Comment createComment(Post post, User author, String text) {

        Comment newComment = null;
        String sql = "INSERT INTO comments (post_id, text, author_name, created_on) values (?, ?, ?, NOW()) RETURNING comment_id";

        try {
            int commentId = jdbcTemplate.queryForObject(sql, int.class, post.getPost_id(), text, author.getUsername());
            newComment = getCommentById(commentId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newComment;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postId) {

        String sql = "SELECT c.*, u.* FROM comments c JOIN users u ON c.author_name = u.username" +
                " WHERE c.post_id = ?" +
                " ORDER BY c.created_on DESC";

        List<Comment> comments = new LinkedList<>();
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId);

            while (result.next()) {
                comments.add(mapRowToComment(result));
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return comments;
    }

    private Comment getCommentById(int commentId) {

        Comment comment = null;
        String sql = "SELECT c.*, u.* FROM comments c JOIN users u ON c.author_name = u.username WHERE c.comment_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, commentId);

            while (result.next()) {
                comment = mapRowToComment(result);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return comment;
    }

    @Override
    public int deleteCommentById(int id) {
        int numberOfRows = 0;
        String sql = "DELETE FROM comments WHERE comment_id = ?";
        try{
            numberOfRows = jdbcTemplate.update(sql, id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }

    @Override
    public Comment updateComment(Comment comment) {
        Comment newComment = null;

        String sql = "UPDATE comments SET text = ? WHERE comment_id = ?";

        try {
            int numberOfRows = 0;
            numberOfRows = jdbcTemplate.update(sql, comment.getText(), comment.getCommentId());

            if(numberOfRows == 0){
                throw new DaoException("No number of rows affected");
            }
            else{
                newComment = getCommentById(comment.getCommentId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newComment;
    }

    public Comment mapRowToComment(SqlRowSet result){
        Comment comment = new Comment();
        comment.setCommentId(result.getInt("comment_id"));
        comment.setText(result.getString("text"));
        comment.setCreatedOn(result.getDate("created_on"));

        User author = jdbcUserDao.mapRowToUser(result);
        comment.setAuthor(author);

        return comment;
    }

}
