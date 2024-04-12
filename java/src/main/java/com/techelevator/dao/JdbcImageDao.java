package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Image;
import com.techelevator.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Component
public class JdbcImageDao implements ImageDao{

    @Autowired
    private JdbcPostDao jdbcPostDao;

    private final JdbcTemplate jdbcTemplate;

    private final String ABSOLUTE_PATH = "C:/Users/Student/workspace/java-gray-finalcapstone-team2/java/src/ImageFiles/";

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public Image createImage(MultipartFile file, int postId) {

        Image createdImage = null;

        String[] words = file.getContentType().split("/");
        String filePath = ABSOLUTE_PATH + UUID.randomUUID() + "." + words[1];


        Image image = new Image(filePath,file.getContentType(),postId);

        String sql = "INSERT INTO images (image_path, image_type, post_id) VALUES (?,?,?) RETURNING image_id;";

        try{

            int imageId = jdbcTemplate.queryForObject(sql, int.class, image.getImagePath(), image.getImageType(), image.getPostId());

            createdImage = getImageById(imageId);

            file.transferTo(new File(filePath));

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


    @Override
    public Image getImageById(int id){

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
    public Image getImageByPath(String path){
        Image image = null;

        String sql = "SELECT * FROM images WHERE image_path = ?";

        try{

            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, path);

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


//    public byte[] getImageByUUID(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
//        String filePath=fileData.get().getFilePath();
//        byte[] images = Files.readAllBytes(new File(filePath).toPath());
//        return images;
//    }

    public Image mapRowToImage(SqlRowSet result){
        Image image = new Image();
        image.setImageId(result.getInt("image_id"));
        image.setImagePath(result.getString("image_path"));
        image.setImageType(result.getString("image_type"));
        image.setPostId(result.getInt("post_id"));
        return image;
    }

}
