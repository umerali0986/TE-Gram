package com.techelevator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RequestMapping(path="/upload")
@RestController
public class FileUploadController {

    File file;

    public FileUploadController(File file){
        this.file = file;
    }
}
