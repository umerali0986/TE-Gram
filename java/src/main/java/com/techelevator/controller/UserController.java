package com.techelevator.controller;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    UserDao userDao;

    UserController(UserDao userDao){
        this.userDao = userDao;
    }

    //TODO add get users
    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id){          //TODO add validation
        userDao.deleteUserById(id);
    }
}
