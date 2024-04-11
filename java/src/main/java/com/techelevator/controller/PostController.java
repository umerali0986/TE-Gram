package com.techelevator.controller;

import com.techelevator.dao.JdbcImageDao;
import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private JdbcPostDao jdbcPostDao;

    @Autowired
    private JdbcUserDao jdbcUserDao;


    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST)
    public Post createPost(@RequestBody Post post, Principal principal){
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        post.setPostCreator(currentUser.getUsername());

        return jdbcPostDao.createPost(post,currentUser.getId());
    }

}
