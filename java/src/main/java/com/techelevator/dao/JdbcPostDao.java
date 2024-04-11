package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class JdbcPostDao implements PostDao {


    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Post createPost(Post post,int userId) {

        Post newPost = null;

        String sql = "INSERT INTO posts (caption, post_creator) values (?, ?) RETURNING post_id";

        try {
            int postId = jdbcTemplate.queryForObject(sql, int.class, post.getCaption(), post.getPostCreator());
            newPost = getPostById(postId);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newPost;
    }

    @Override
    public Post getPostById(int id) {

        Post post = null;
        String sql = "SELECT * FROM posts WHERE post_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if (result.next()) {
                post = mapRowToPost(result);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return post;
    }

    @Override
    public void deletePostById(int id) {

    }

    @Override
    public Post updatePost(Post post) {
        return null;
    }


    public Post mapRowToPost(SqlRowSet result){
        Post post = new Post();

        post.setPost_id(result.getInt("post_id"));
        post.setCaption(result.getString("caption"));
        post.setPostCreator(result.getString("post_creator"));

        return post;
    }

}
