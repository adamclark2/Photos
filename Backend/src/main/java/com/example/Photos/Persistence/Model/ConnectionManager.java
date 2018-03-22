package com.example.Photos.Persistence.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Consumer;

public class ConnectionManager {
    private volatile Connection database;
    private static ConnectionManager man;

    private ConnectionManager(){
        try {
            database = DriverManager.getConnection("jdbc:mysql://" + System.getenv("DATABASE_URL").replace("\"", ""));
        }catch (SQLException ee){
            // TODO
            throw new RuntimeException("oops!!! " + ee.getMessage() + ee.getCause() + "\n" + ee.getSQLState());
        }
    }

    public static ConnectionManager getConnectionManager(){
        if(man == null){
            man = new ConnectionManager();
        }

        return man;
    }

    public void useConnectionNow(Consumer<Connection> c){
        if(database == null){
            throw new RuntimeException("The database was null ... did database get initialized properly?");
        }

        synchronized (database) {
            c.accept(database);
        }
        return;
    }
}
