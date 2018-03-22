package com.example.Photos.Persistence.Model;

import com.example.Photos.Persistence.GenericDao;
import com.example.Photos.Model.ImageMetadata;
import java.util.List;

/*
A class to handle the data access of specifically the metadata of images
 */
public class ImageMetadataDao {

    private GenericDao<ImageMetadata> dao;

    public ImageMetadataDao(GenericDao genericDao){
        this.dao = genericDao;
    }

    /**
     * Return a list of the metadata of all images currently stored
     * @return a list of type 'ImageMetadata'
     */
    public List<ImageMetadata> getAllImageMetadata(){
        return dao.getAll();
    }

    /**
     * Return a specific ImageMetadata object based on an identifier
     * @param id is the identifier of the sought after object
     * @return an instance of type ImageMetadata
     */
    public ImageMetadata getImageMetadata(long id){
        return dao.get(id);
    }
}
