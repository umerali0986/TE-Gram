package com.techelevator.model;

public class Image {
    private int imageId;

    private String imagePath;

    private String imageType;

    public Image() {
    }

    public Image(int imageId, String imagePath, String imageType){
        this.imageId = imageId;
        this.imagePath = imagePath;
        this.imageType = imageType;
    }

    public Image(String imagePath, String imageType) {
        this.imagePath = imagePath;
        this.imageType = imageType;
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
}
