package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFavoriteDao implements FavoriteDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private JdbcPostDao jdbcPostDao;

    public JdbcFavoriteDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Favorite> getFavoritesByUserId(int userId) {
        List<Favorite> favorites = new ArrayList<>();

        String sql = "SELECT * FROM favorites WHERE user_id = ?";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while(results.next()){
                favorites.add(mapRowToFavorite(results));
            }
        } catch(CannotGetJdbcConnectionException e){
            throw new DaoException("Could not access the database", e);
        }

        return favorites;
    }

    @Override
    public void createFavoriteByUserIdAndPostId(int userId, int postId) {
        String sql = "INSERT INTO favorites (post_id, user_id) values (?, ?)";

        try {
            int numOfReturned = jdbcTemplate.update(sql, postId, userId);
            if (numOfReturned == 0) {
                throw new DaoException("No favorite added");
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public void deleteFavoriteByUserIdAndPostId(int userId, int postId) {

        String sql = "DELETE FROM favorites WHERE user_id = ? AND post_id = ?";

        try {
            int rowsAffected = jdbcTemplate.update(sql, userId, postId);
            if (rowsAffected == 0) {
                throw new DaoException("No favorite removed");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
    }

    @Override
    public boolean hasUserFavoritePostById(int postId, int userId) {
        String sql = "SELECT COUNT(*) AS favorite FROM favorites WHERE post_id = ? AND user_id = ?;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId, userId);
            if (result.next()) {
                return result.getInt("favorite") > 0;
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);

        }

        return false;
    }


    public Favorite mapRowToFavorite(SqlRowSet rowSet){
        Favorite favorite = new Favorite();
        favorite.setPostId(rowSet.getInt("post_id"));
        favorite.setUserId(rowSet.getInt("user_id"));
        favorite.setPost(jdbcPostDao.getPostById(favorite.getPostId()));
        return favorite;
    }
}
