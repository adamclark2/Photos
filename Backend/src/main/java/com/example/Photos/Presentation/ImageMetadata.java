package com.example.Photos.Presentation;

public class ImageMetadata {
    private int imageId;
    private String title;
    private String url;

    public ImageMetadata(){}
    public ImageMetadata(int id, String text, String urlP){
        this.imageId = id;
        this.title = text;
        this.url = urlP;
    }
}
