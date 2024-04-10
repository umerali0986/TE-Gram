package com.techelevator.controller;

import com.techelevator.dao.JdbcImageDao;
import com.techelevator.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RequestMapping(path="/upload")
@RestController
public class FileUploadController {

    @Autowired
    private JdbcImageDao jdbcImageDao;

    @RequestMapping(method = RequestMethod.POST)
    public Image createImage(@RequestParam("image") MultipartFile file){

        return jdbcImageDao.createImage(file);
    }



}
