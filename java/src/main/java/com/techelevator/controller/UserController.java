package com.techelevator.controller;

import com.techelevator.dao.JdbcUserDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/users")
public class UserController {
    UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }


    @RequestMapping(path = "/all",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){
        return  userDao.getUserById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public User getUserByEmail(@RequestParam("email") String email){
        return  userDao.getUserByEmail(email);
    }

    @RequestMapping(path="/profile/{username}", method=RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username){
        return userDao.getUserByUsername(username);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User updateUser(@RequestBody User updatedUser){
        System.out.println("User's password: " + updatedUser.getPassword());
        return  userDao.updateUser(updatedUser);
    }

    @RequestMapping(path="/{id}", method= RequestMethod.DELETE)
    public void deleteUserById(@PathVariable int id){
        userDao.deleteUserById(id);
    }
}
