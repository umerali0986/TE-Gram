package com.techelevator.controller;

import com.techelevator.dao.JdbcImageDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.Image;
import com.techelevator.model.Post;
import com.techelevator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.security.Principal;


@RestController
@RequestMapping(path="/upload")
@CrossOrigin
public class FileUploadController {
    @Autowired
    private JdbcUserDao jdbcUserDao;
    @Autowired
    private JdbcImageDao jdbcImageDao;

//    @RequestMapping(path = "/{postId}",method = RequestMethod.POST)
//    public Image createImage(@RequestParam("image") MultipartFile file, @PathVariable int postId){
//
//        return jdbcImageDao.createImage(file,postId);
//    }

    @RequestMapping(path="/{postId}", method=RequestMethod.GET)
    public Image getImageByPostId(@PathVariable int postId){
        return jdbcImageDao.getImageByPostId(postId);
    }

//    @RequestMapping(path="/{uuid}", method=RequestMethod.GET)
//    public Image getImageByPostId(@PathVariable String uuid){
//        return jdbcImageDao.getImageByUUID(uuid);
//    }



}
