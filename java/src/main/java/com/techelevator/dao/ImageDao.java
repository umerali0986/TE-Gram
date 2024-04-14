package com.techelevator.dao;

import com.techelevator.model.Image;
import com.techelevator.model.Post;
import org.springframework.web.multipart.MultipartFile;

public interface ImageDao {

    Image createImage(MultipartFile file, int postId, String altDesc);

    Image getImageByPostId(int postId);
}
