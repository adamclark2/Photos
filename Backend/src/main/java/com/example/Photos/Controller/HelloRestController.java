package com.example.Photos.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
public class HelloRestController {

    @RequestMapping("/")
    public message helloWorld(){
        message m = new message();

        // gson is automatically set
        // as a marshaller via spring auto-config
        // :D
        //
        // The `old` way via GsonBuilder still works
        return m;
    }

    public class message{
        public String hello = "world";
        public String world = "helllo";
    }

    @RequestMapping(value = "/dbTest", produces = "text/plain")
    public String database(){
        return doDatabase();
    }

    public static String doDatabase(){
        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://"
                    + (System.getenv("DATABASE_URL").replace("\"", "")));
            PreparedStatement p = c.prepareStatement("SELECT * FROM helloworld");
            ResultSet rs = p.executeQuery();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PrintWriter pr = new PrintWriter(bos);

            // Header
            int colCount = rs.getMetaData().getColumnCount();
            for(int i = 1; i < colCount;i++){
                pr.printf("%20s|", rs.getMetaData().getColumnName(i) + "/" + rs.getMetaData().getColumnTypeName(i) );
            }
            pr.printf("%20s", rs.getMetaData().getColumnName(colCount) + "/" + rs.getMetaData().getColumnTypeName(colCount - 1));
            pr.println();
            for(int i = 0;i < (20 + 1) * colCount;i++){
                pr.printf("-");
            }
            pr.println();

            // Data
            while(rs.next()){
                for(int i = 1; i < colCount;i++){
                    pr.printf("%20s|", rs.getString(i));
                }
                pr.printf("%20s", rs.getString(colCount));
                pr.println();
            }
            c.close();
            pr.flush();

            return new String(bos.toByteArray());


        }catch (Exception e){
            // OOPS
            e.printStackTrace();
            return "xyz" + e.getLocalizedMessage() + e.getMessage();
        }
    }
}
