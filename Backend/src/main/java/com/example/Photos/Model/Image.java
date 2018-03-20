package com.example.Photos.Model;

public class Image {

    private long id;
    private String sender;
    private String timeStamp;
    private String url;
    private byte[] imageBytes;

    public Image(long id, String sender, String timeStamp, String url, byte[] imageBytes) {
        this.id = id;
        this.sender = sender;
        this.timeStamp = timeStamp;
        this.url = url;
        this.imageBytes = imageBytes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}
