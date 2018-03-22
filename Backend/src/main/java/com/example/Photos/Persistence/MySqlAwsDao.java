package com.example.Photos.Persistence;

import java.util.List;

/*
 * An implementation of the DAO interface that contains specific implementation details
 * regarding database operations on a MySQL database, hosted in AWS.
 */
public class MySqlAwsDao<T> implements GenericDao {

    @Override
    public T get(long id) {
        return null;
    }

    @Override
    public List<T> getAll() {
        /*
         * *** IMPLEMENT THE DATABASE CONNECTING AND GATHERING OF METADATA HERE!
         */
        return null;
    }
}
