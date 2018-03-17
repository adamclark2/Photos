package com.example.Photos.Persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
A persistence implementation that simply uses an in memory hashmap to store objects
 */
public class InMemoryDao<T> implements GenericDao {

    private Map<T, T> database = new HashMap<>();

    /**
     * Return a single element corresponding to an identifier
     * @param id is the identifier of the object to return
     * @return a single element of type T
     */
    @Override
    public T get(long id) {
        return null;
    }

    /**
     * Return a list of all the objects stored within the hashmap in memory
     * @return a list of type T
     */
    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        for(T item : database.values()){
            list.add(item);
        }
        return list;
    }
}
