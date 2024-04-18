package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao {



    private final JdbcTemplate jdbcTemplate;

    public JdbcPostDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Post> getAllPosts() throws DaoException {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts ORDER BY post_id DESC;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

            while (result.next()) {
                Post post = mapRowToPost(result);
                posts.add(post);
                post.setTotalLikes(countPostLikes(post.getId()));
                post.setTotalFavorites(countPostFavorites(post.getId()));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return posts;
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

        // Compute likes.
        post.setTotalLikes(countPostLikes(id));
        post.setTotalFavorites(countPostFavorites(id));
        return post;
    }

    @Override
    public List<Post> getPostsByCreator(String creator) {
        List<Post> creatorPosts = new ArrayList<>();

        String sql = "SELECT * FROM posts WHERE post_creator = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, creator);
            while(results.next()){
                creatorPosts.add(mapRowToPost(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return creatorPosts;
    }

    public int countPostLikes(int postId) {
        String sql = "SELECT COUNT(*) AS likes FROM likes WHERE post_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId);

            if (result.next()) {
                return result.getInt("likes");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return 0;
    }

    public int countPostFavorites(int postId) {
        String sql = "SELECT COUNT(*) AS favorrites FROM favorites WHERE post_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId);

            if (result.next()) {
                return result.getInt("favorrites");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return 0;
    }

    @Override
    public boolean hasUserLikedPostById(int postId, String authorName) {
        String sql = "SELECT COUNT(*) AS likes FROM likes WHERE post_id = ? AND author_name = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId, authorName);
            if (result.next()) {
                return result.getInt("likes") > 0;
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return false;
    }

    @Override
    public int deletePostById(int post_id) {
        int numberOfRows = 0;

        String sql = "DELETE from comments where post_id = ?; " +
                     "DELETE FROM favorites WHERE post_id = ?; " +
                     "DELETE FROM likes WHERE post_id = ?; " +
                     "DELETE FROM images WHERE post_id = ?; " +
                     "DELETE FROM posts WHERE post_id = ?;";

        try{
            numberOfRows = jdbcTemplate.update(sql, post_id,post_id,post_id,post_id,post_id);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return numberOfRows;
    }


    @Override
    public int deleteCommentById(int comment_id) {
        int numberOfRows = 0;
        String sql = "DELETE from comments where comment_id = ?; ";

        try{
                        numberOfRows = jdbcTemplate.update(sql, comment_id);
                    
                    } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        } 

        return numberOfRows;
    }

    @Override
    public Post updatePost(Post post) {
        Post newPost = null;

        String sql = "UPDATE posts SET caption = ? WHERE post_id = ?";

        try {
            int numberOfRows = 0;
            numberOfRows = jdbcTemplate.update(sql, post.getCaption(), post.getId());

            if(numberOfRows == 0){
                throw new DaoException("No number of rows affected");
            }
            else{
                newPost = getPostById(post.getId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newPost;
    }

    @Override
    public void addLike(Post post, User author) {
        String sql = "INSERT INTO likes (post_id, author_name) values (?, ?)";

        try {
            int postId = jdbcTemplate.update(sql, post.getId(), author.getUsername());
            if (0 == postId) {
                throw new DaoException("No like added");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void removeLike(Post post, User author) {
        String sql = "DELETE FROM likes WHERE post_id = ? AND author_name = ?";

        try {
            int postId = jdbcTemplate.update(sql, post.getId(), author.getUsername());
            if (0 == postId) {
                throw new DaoException("No like removed");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public Post makePostPrivateById(int postId) {
        Post newPost = null;

        String sql = "UPDATE posts SET is_private = 'true' WHERE post_id = ?";

        try {
            int numberOfRows = 0;
            numberOfRows = jdbcTemplate.update(sql, postId);

            if(numberOfRows == 0){
                throw new DaoException("No number of rows affected");
            }
            else{
                newPost = getPostById(postId);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newPost;
    }

    @Override
    public Post makePostPublicById(int postId) {
        Post newPost = null;

        String sql = "UPDATE posts SET is_private = 'false' WHERE post_id = ?";

        try {
            int numberOfRows = 0;
            numberOfRows = jdbcTemplate.update(sql, postId);

            if(numberOfRows == 0){
                throw new DaoException("No number of rows affected");
            }
            else{
                newPost = getPostById(postId);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newPost;
    }


    public Post mapRowToPost(SqlRowSet result){
        Post post = new Post();

        post.setId(result.getInt("post_id"));
        post.setCreatedOn(result.getTimestamp("created_on"));
        post.setCaption(result.getString("caption"));
        post.setPostCreator(result.getString("post_creator"));
        post.setPrivate(result.getBoolean("is_private"));

        return post;
    }

}
