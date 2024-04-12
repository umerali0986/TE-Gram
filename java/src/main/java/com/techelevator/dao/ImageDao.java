package com.techelevator.dao;

import com.techelevator.model.Image;
import com.techelevator.model.Post;
import org.springframework.web.multipart.MultipartFile;

public interface ImageDao {

<<<<<<< HEAD
    Image createImage(MultipartFile file, int postId);

    Image getImageById(int id);

    Image getImageByPath(String path);
=======
    Image createImage(MultipartFile file, int postId, String altDesc);
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd

    Image getImageByPostId(int postId);
}
