package com.techelevator.model;

public class Image {
    private int imageId;

    private String imagePath;

    private String imageType;

    private int postId;

    public Image() {
    }

    public Image(int imageId, String imagePath, String imageType, int postId){
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.imageType = imageType;
        this.postId = postId;
    }

    public Image(String imagePath, String imageType,int postId) {
        this.imagePath = imagePath;
        this.imageType = imageType;
        this.postId = postId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
