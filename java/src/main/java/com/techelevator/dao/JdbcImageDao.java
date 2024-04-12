package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Image;
<<<<<<< HEAD
import com.techelevator.model.Post;
=======
import com.techelevator.util.ImageFileProvider;
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class JdbcImageDao implements ImageDao{

    @Autowired
    private JdbcPostDao jdbcPostDao;

    private final JdbcTemplate jdbcTemplate;

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

<<<<<<< HEAD



    public Image createImage(MultipartFile file, int postId) {
=======
    public Image createImage(MultipartFile file, int postId, String altDesc) {
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd

        Image createdImage = null;

        String contentType = file.getContentType();
        if (null == contentType)
            throw new IllegalArgumentException("Unsupported content type");

<<<<<<< HEAD

        Image image = new Image(filePath,file.getContentType(),postId);

        String sql = "INSERT INTO images (image_path, image_type, post_id) VALUES (?,?,?) RETURNING image_id;";

        try{

            int imageId = jdbcTemplate.queryForObject(sql, int.class, image.getImagePath(), image.getImageType(), image.getPostId());
=======
        String imageType = contentType.split("/")[1];

        String sql = "INSERT INTO images (image_type, post_id, alt_desc) VALUES (?,?, ?) RETURNING image_id;";

        try{

            int imageId = jdbcTemplate.queryForObject(sql, int.class, imageType, postId, altDesc);
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd

            createdImage = getImageById(imageId);

            File imageFile = new ImageFileProvider().createImageFile(createdImage);
            file.transferTo(imageFile);

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        catch (IOException e){
            throw new DaoException("Something went wrong please try it again", e);

        }

        return createdImage;
    }

    private Image getImageById(int id){

        Image image = null;

        String sql = "SELECT * FROM images WHERE image_id = ?";

        try{

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

            if(result.next()) {
                image = mapRowToImage(result);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return image;
    }

    @Override
    public Image getImageByPostId(int postId){
        Image image = null;

        String sql = "SELECT * FROM images WHERE post_id = ?";

        try{

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, postId);

            if(result.next()) {
                image = mapRowToImage(result);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return image;
    }

<<<<<<< HEAD

//    public byte[] getImageByUUID(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
//        String filePath=fileData.get().getFilePath();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }

=======
>>>>>>> 10eee9847abd85a99ffab8938981a32e5c4647fd
    public Image mapRowToImage(SqlRowSet result){
        Image image = new Image();
        image.setImageId(result.getInt("image_id"));
        image.setImageType(result.getString("image_type"));
        image.setAltDesc(result.getString("alt_desc"));
        image.setPostId(result.getInt("post_id"));
        return image;
    }

}
