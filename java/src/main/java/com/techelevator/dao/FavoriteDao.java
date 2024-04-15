package com.techelevator.dao;

import com.techelevator.model.Favorite;

import java.util.List;

public interface FavoriteDao {

    List<Favorite> getFavoritesByUserId(int userId);

    void createFavoriteByUserIdAndPostId(int userId, int postId);

    void deleteFavoriteByUserIdAndPostId(int userId, int postId);

}
