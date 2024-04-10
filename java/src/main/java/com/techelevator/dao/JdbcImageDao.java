package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Image;
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

    private final JdbcTemplate jdbcTemplate;

    private final String ABSOLUTE_PATH = "C:/Users/Student/workspace/java-gray-finalcapstone-team2/java/src/ImageFiles/";

    public JdbcImageDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // Add UUID to file path
    @Override
    public Image createImage(MultipartFile file) {

        Image createdImage = null;

        String filePath = ABSOLUTE_PATH + file.getOriginalFilename();

        Image image = new Image(filePath,file.getContentType());

        String sql = "INSERT INTO images (image_path, image_type) VALUES (?,?) RETURNING image_id;";

        try{

            int imageId = jdbcTemplate.queryForObject(sql, int.class, image.getImagePath(), image.getImageType());

            createdImage = getImageById(imageId);

            file.transferTo(new File(filePath));

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        catch (IOException e){
            throw new DaoException("Something went please try it again", e);

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


    public Image mapRowToImage(SqlRowSet result){
        Image image = new Image();

        image.setImageId(result.getInt("image_id"));
        image.setImagePath(result.getString("image_path"));
        image.setImageType(result.getString("image_type"));

        return image;
    }

}
