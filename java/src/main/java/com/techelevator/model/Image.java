package com.techelevator.model;

public class Image {
    private int imageId;

    private String imageType;

    private int postId;

    private String altDesc;
    private String avatarId;

    public Image() {
    }


    public Image(String avatarId, String imageType) {
        this.avatarId = avatarId;
        this.imageType = imageType;
    }

    public Image(int imageId, String imageType, int postId, String altDesc) {
        this.imageId = imageId;
        this.imageType = imageType;
        this.postId = postId;
        this.altDesc = altDesc;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
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

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getAltDesc() {
        return altDesc;
    }

    public void setAltDesc(String altDesc) {
        this.altDesc = altDesc;
    }
}
