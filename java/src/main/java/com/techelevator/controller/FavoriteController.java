package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Favorite;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path="/favorites")
public class FavoriteController {
    @Autowired
    private JdbcPostDao jdbcPostDao;

    @Autowired
    private JdbcUserDao jdbcUserDao;

    @Autowired
    private JdbcFavoriteDao jdbcFavoriteDao;

    @RequestMapping(path="/{userId}", method= RequestMethod.GET)
    public List<Favorite> getFavoritesByUserId(@PathVariable int userId){
        return jdbcFavoriteDao.getFavoritesByUserId(userId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/favorite", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createFavoriteByUserIdAndPostId(@PathVariable int postId, Principal principal) throws IOException {
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        jdbcFavoriteDao.createFavoriteByUserIdAndPostId(currentUser.getId(), postId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/unfavorite", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFavoriteByUserIdAndPostId(@PathVariable int postId, Principal principal) throws IOException {
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        jdbcFavoriteDao.deleteFavoriteByUserIdAndPostId(currentUser.getId(), postId);
    }

}
