package com.example.Photos.Persistence.Model;

import com.example.Photos.Model.Image;
import com.example.Photos.Persistence.GenericDao;

import java.util.List;

/*
A class that performs persistence tasks with Image objects
 */
public class ImageDao {

    private GenericDao<Image> dao;

    // At this point we decide what implementation of persistence we want.
    public ImageDao(GenericDao genericDao){
        this.dao = genericDao;
    }
    /**
     * Return all images
     * @return a list of type Image
     */
    public List<Image> getAllImages(){
        return dao.getAll();
    }

    /**
     * Return a single images based on an identifier
     * @param id is the identifier of the sought after Image
     * @return a single Image
     */
    public Image getImage(long id){
        return dao.get(id);
    }
}
