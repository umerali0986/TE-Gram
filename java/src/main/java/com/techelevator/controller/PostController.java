package com.techelevator.controller;

import com.techelevator.dao.*;
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

@CrossOrigin
@RestController
@RequestMapping(path = "/posts")
public class PostController {

    @Autowired
    private JdbcPostDao jdbcPostDao;

    @Autowired
    private JdbcUserDao jdbcUserDao;

    @Autowired
    private JdbcImageDao jdbcImageDao;

    @Autowired
    private JdbcFavoriteDao jdbcFavoriteDao;

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
        Image image = jdbcImageDao.createImage(file, postInfo.getId(), altDesc);

        // Return both post info + image info.
        return new PostWithImage(postInfo, image);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Post> getAllPosts(Principal principal) {
        List<Post> posts = jdbcPostDao.getAllPosts();

        if (principal != null) {
            User currentUser = jdbcUserDao.getUserByUsername(principal.getName());

            for (Post post : posts) {
                if (null != currentUser) {
                    post.setLiked(jdbcPostDao.hasUserLikedPostById(post.getId(), currentUser.getUsername()));
                    post.setFavorite(jdbcFavoriteDao.hasUserFavoritePostById(post.getId(), currentUser.getId()));
                }
            }
        }

        return posts;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}", method = RequestMethod.GET)
    public PostWithImage getPostById(@PathVariable int postId, Principal principal) {
        Post postInfo = jdbcPostDao.getPostById(postId);
        Image image = jdbcImageDao.getImageByPostId(postId);

        // Check if the current user has liked the post.
        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());
        if ( currentUser != null) {
            postInfo.setFavorite(jdbcFavoriteDao.hasUserFavoritePostById(postId, currentUser.getId()));
            postInfo.setLiked(jdbcPostDao.hasUserLikedPostById(postId, currentUser.getUsername()));
        }

        // 3. Get comments.
        List<Comment> comments = jdbcCommentDao.getCommentsByPostId(postInfo.getId());

        // Return both post info + image info + comments.
        return new PostWithImage(postInfo, image, comments);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path="/{username}/posts", method=RequestMethod.GET)
    public List<Post> getPostsByUsername(@PathVariable String username, Principal principal){
        List<Post> posts = jdbcPostDao.getPostsByCreator(username);

        User currentUser = jdbcUserDao.getUserByUsername(principal.getName());

        if (currentUser != null) {

            for (Post post : posts) {
                    post.setLiked(jdbcPostDao.hasUserLikedPostById(post.getId(), currentUser.getUsername()));
                    post.setFavorite(jdbcFavoriteDao.hasUserFavoritePostById(post.getId(), currentUser.getId()));
                    post.setTotalLikes(jdbcPostDao.countPostLikes(post.getId()));
                    post.setTotalFavorites(jdbcPostDao.countPostFavorites(post.getId()));
            }
        }

        return posts;
    }

    @RequestMapping(path = "/{postId}/image", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getPostImageById(@PathVariable int postId) throws IOException {
        Image image = jdbcImageDao.getImageByPostId(postId);
        File imageFile = new ImageFileProvider().createImageFile(image, true);
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

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/delete/{postId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable int postId){
        jdbcPostDao.deletePostById(postId);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/comment/{commentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCommentById(@PathVariable int commentId){
        jdbcPostDao.deleteCommentById(commentId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/private", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Post makePostPrivateById(@PathVariable int postId){
        return jdbcPostDao.makePostPrivateById(postId);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/{postId}/public", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Post makePostPublicById(@PathVariable int postId){
        return jdbcPostDao.makePostPublicById(postId);
    }

}
