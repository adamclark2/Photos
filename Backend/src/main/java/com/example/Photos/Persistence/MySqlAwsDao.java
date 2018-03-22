package com.example.Photos.Persistence;

import com.example.Photos.Persistence.GenericDao;
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
        return null;
    }
}
