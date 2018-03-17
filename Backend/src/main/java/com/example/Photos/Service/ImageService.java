package com.example.Photos.Service;

import com.example.Photos.Model.Image;
import com.example.Photos.Persistence.ImageDao;
import com.example.Photos.Persistence.InMemoryDao;

import java.util.ArrayList;
import java.util.List;

public class ImageService {

    private ImageDao imageDao;

    public ImageService(){
        // We are using an in memory data store at this point...
        imageDao = new ImageDao(new InMemoryDao());
    }

    /**
     * Gather a list of the URLs of all the images in storage
     * @return a list of type String
     */
    public List<String> getAllImageUrls(){
        List<String> imageUrls = new ArrayList<>();
        for(Image i : imageDao.getAllImages()){
            imageUrls.add(i.getUrl());
        }
        return imageUrls;
    }
}
