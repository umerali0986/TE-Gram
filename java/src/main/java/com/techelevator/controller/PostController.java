package com.techelevator.controller;

import com.techelevator.dao.JdbcCommentDao;
import com.techelevator.dao.JdbcImageDao;
import com.techelevator.dao.JdbcPostDao;
import com.techelevator.dao.JdbcUserDao;
import com.techelevator.model.*;
import com.techelevator.util.ImageFileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private JdbcPostDao jdbcPostDao;

    @Autowired
    private JdbcUserDao jdbcUserDao;

    @Autowired
    private JdbcImageDao jdbcImageDao;

    @Autowired
    private JdbcCommentDao jdbcCommentDao;

    /*
     * This method does two things:
     * - Create the post
     * - Upload the image
     *
     * TODO: Make these operations a transaction (all-or-nothing fashion),
     *  so that if either fails, nothing gets committed.
     */
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.POST)
    public PostWithImage createPost(
            @RequestParam("image") MultipartFile file,
            @RequestParam("caption") String caption,
            @RequestParam(value = "alt_desc", required = false) String altDesc,
            Principal principal) {

        // 1. Create the post.
        Post post = new Post();
        post.setCaption(caption);
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        post.setPostCreator(currentUser.getUsername());
        Post postInfo = jdbcPostDao.createPost(post, currentUser.getId());

        // 2. Upload the post image.
        Image image = jdbcImageDao.createImage(file, postInfo.getPost_id(), altDesc);

        // Return both post info + image info.
        return new PostWithImage(postInfo, image);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getAllPosts() {
        return jdbcPostDao.getAllPosts();
    }

    @RequestMapping(path = "/{postId}", method = RequestMethod.GET)
    public PostWithImage getPostById(@PathVariable int postId, Principal principal) {
        Post postInfo = jdbcPostDao.getPostById(postId);
        Image image = jdbcImageDao.getImageByPostId(postId);

        // Check if the current user has liked the post.
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        if (null != currentUser) {
            postInfo.setLiked(jdbcPostDao.hasUserLikedPostById(postId, currentUser.getUsername()));
        }

        // 3. Get comments.
        List<Comment> comments = jdbcCommentDao.getCommentsByPostId(postInfo.getPost_id());

        // Return both post info + image info + comments.
        return new PostWithImage(postInfo, image, comments);
    }

    @RequestMapping(path = "/{postId}/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPostImageById(@PathVariable int postId) throws IOException {
        Image image = jdbcImageDao.getImageByPostId(postId);
        File imageFile = new ImageFileProvider().createImageFile(image);
        byte[] imageData = Files.readAllBytes(imageFile.toPath());
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf(String.format("image/%s", image.getImageType())))
                .body(imageData);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/like", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void likePostById(@PathVariable int postId, Principal principal) throws IOException {
        Post postInfo = jdbcPostDao.getPostById(postId);
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        jdbcPostDao.addLike(postInfo, currentUser);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/unlike", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlikePostById(@PathVariable int postId, Principal principal) throws IOException {
        Post postInfo = jdbcPostDao.getPostById(postId);
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        jdbcPostDao.removeLike(postInfo, currentUser);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/comment", method = RequestMethod.POST)
    public Comment commentPostById(@PathVariable int postId,
                               @RequestBody Comment comment,
                               Principal principal) throws IOException {
        Post postInfo = jdbcPostDao.getPostById(postId);
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        return jdbcCommentDao.createComment(postInfo, currentUser, comment.getText());
    }

}
