package com.example.Photos.Persistence;

import java.util.List;

/*
A generic data access interface to outline some of the functionality
we are looking for regarding databases.
 */
public interface GenericDao<T> {

    /**
     * return a specific element from persistence
     * @param id is the identifier of the object to return
     * @return the desired object
     */
    public T get(long id);

    /**
     * return a list of all the objects stored in persistence
     * @return a list of objects
     */
    public List<T> getAll();
}
