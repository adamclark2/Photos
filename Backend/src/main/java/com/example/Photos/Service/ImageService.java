package com.example.Photos.Service;

import com.example.Photos.Model.Image;
import com.example.Photos.Presentation.ImageMetadata;
import java.util.List;

/*
An interface to outline the core functionality we want with regards to working with images
 */
public interface ImageService {

    /**
     * Generate a list of all metadata pertaining to images
     * @return a list of type Metadata
     */
    public List<ImageMetadata> getImageMetadata();

    /**
     * Generate a list of images
     * @return a list of type Image
     */
    public List<Image> getImages();
}
