package com.example.Photos.Service;

import com.example.Photos.Model.Image;
import com.example.Photos.Persistence.Model.ImageDao;
import com.example.Photos.Persistence.InMemoryDao;
import com.example.Photos.Persistence.Model.ImageMetadataDao;
import com.example.Photos.Presentation.ImageMetadata;

import java.util.ArrayList;
import java.util.List;

public class ImageServiceImp implements ImageService {

    private ImageDao imageDao;
    private ImageMetadataDao metadataDao;

    public ImageServiceImp(){
        // We are using an in memory data store at this point...
        imageDao = new ImageDao(new InMemoryDao());
        metadataDao = new ImageMetadataDao(new InMemoryDao());
    }

    @Override
    public List<ImageMetadata> getImageMetadata() {
        List<ImageMetadata> metadataList = new ArrayList<>();
        for(ImageMetadata i : metadataDao.getAllImageMetadata()){
            metadataList.add(i);
        }
        return metadataList;
    }

    @Override
    public List<Image> getImages() {
        // These will be stored separately from the metadata, and we dont need these atm.
        return null;
    }
}
