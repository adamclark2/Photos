package com.example.Photos.Service;

import com.example.Photos.Model.Image;
import com.example.Photos.Persistence.Model.ImageDao;
import com.example.Photos.Persistence.InMemoryDao;
import com.example.Photos.Persistence.Model.ImageMetadataDao;
import com.example.Photos.Model.ImageMetadata;
import com.example.Photos.Persistence.MySqlAwsDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ImageServiceImp implements ImageService {

    private ImageDao imageDao;
    private ImageMetadataDao metadataDao;

    public ImageServiceImp(){
        // We are using MySQL hosted in AWS at this point...
        imageDao = new ImageDao(new MySqlAwsDao());
        metadataDao = new ImageMetadataDao(new MySqlAwsDao());
    }

    @Override
    public List<ImageMetadata> getImageMetadata() {
        List<ImageMetadata> metadataList = new ArrayList<>();
        for(ImageMetadata i : metadataDao.getAllImageMetadata()){
            metadataList.add(i);
        }
        return metadataList;
    }

    /**
     * Return a list of all image URLS stored in memory.  Useful because we want them to lazy
     * load the corresponding images from the client apps.
     * @return
     */
    @Override
    public List<String> getImageUrls() {
        return metadataDao.getAllImageMetadata().stream().map(e -> e.getUrl()).collect(Collectors.toList());
    }

    @Override
    public List<Image> getImages() {
        // These will be stored separately from the metadata, and we dont need these atm.
        return null;
    }
}
