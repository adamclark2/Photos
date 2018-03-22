package com.example.Photos.Model;

import com.example.Photos.Model.Messages.ImageMetadataMessage;
import com.example.Photos.Model.Messages.ServerMessage;

/*
 * A class to represent the data associated with an image, minus the actual picture itself lol.
 */
public abstract class ImageMetadata implements ServerMessage<ImageMetadataMessage>{

    public ImageMetadata(){}

    public abstract long getImageId();


    public abstract String getTitle();
    public abstract void setTitle(String title);

    public abstract String getUrl();

    public abstract long getTimeStamp();
    public abstract void setTimeStamp(long timeStamp);

    public abstract String getSender();
    public abstract void setSender(String sender);

    @Override
    public ImageMetadataMessage getMessage() {
        ImageMetadataMessage imm = new ImageMetadataMessage();
        imm.id = getImageId();
        imm.imageUrl = System.getenv("S3_BASE_BUCKET").replace("\"", "") + "/" + imm.id + ".png";
        imm.title = getTitle();
        imm.sender = getSender();
        imm.timeStamp = getTimeStamp();

        return imm;
    }
}
