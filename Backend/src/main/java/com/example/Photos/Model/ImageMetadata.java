package com.example.Photos.Model;

/*
 * A class to represent the data associated with an image, minus the actual picture itself lol.
 */
public class ImageMetadata {
    private long imageId;
    private String title;
    private String url;
    private String timeStamp;
    private String sender;

    public ImageMetadata(long imageId, String title, String url){
        this.imageId = imageId;
        this.title = title;
        this.url = url;
    }

    public ImageMetadata(){}

    public ImageMetadata(long imageId, String title, String url, String timeStamp, String sender) {
        this.imageId = imageId;
        this.title = title;
        this.url = url;
        this.timeStamp = timeStamp;
        this.sender = sender;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
