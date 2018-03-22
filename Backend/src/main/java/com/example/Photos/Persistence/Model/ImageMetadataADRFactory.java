package com.example.Photos.Persistence.Model;

import com.example.Photos.Model.ImageMetadata;
import com.example.Photos.Model.Messages.ImageMetadataMessage;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImageMetadataADRFactory {

    public ImageMetadata getImageMetadata(long id){
        ImageMetadata m[] = new ImageMetadata[0];
        ConnectionManager.getConnectionManager().useConnectionNow(con -> {
            m[0] = getImageMetadata(id, con);
        });

        return m[0];
    }

    private ImageMetadata getImageMetadata(long id, Connection con){
        try {
            ImageMetadata im[] = new ImageMetadata[1];

            PreparedStatement getTitle = con.prepareStatement("SELECT title FROM ImageMetadata WHERE id=?;");
            PreparedStatement setTitle = con.prepareStatement("UPDATE ImageMetadata SET title=? WHERE id=?;");
            PreparedStatement getTimeStamp = con.prepareStatement("SELECT time FROM ImageMetadata WHERE id=?;");
            PreparedStatement setTimeStamp = con.prepareStatement("UPDATE ImageMetadata SET time=? WHERE id=?;");
            PreparedStatement getSender = con.prepareStatement("SELECT sender FROM ImageMetadata WHERE id=?");
            PreparedStatement setSender = con.prepareStatement("UPDATE ImageMetadata SET sender=? WHERE id=?");

            im[0] = new ImageMetadata() {
                @Override
                public long getImageId() {
                    return id;
                }

                @Override
                public String getTitle() {
                    return runPreparedGetString(getTitle, id);
                }

                @Override
                public void setTitle(String title) {
                    try {
                        setTitle.setString(1, title);
                        setTitle.setLong(2, id);
                        setTitle.execute();
                    } catch (SQLException e) {
                        throw new RuntimeException("Bad setTitle");
                    }
                }

                @Override
                public String getUrl() {
                    // TODO
                    return "http://google.com";
                }

                @Override
                public long getTimeStamp() {
                    try {
                        getTimeStamp.setLong(1, id);
                        ResultSet rs = getTimeStamp.executeQuery();
                        rs.next();
                        return rs.getLong(1);
                    } catch (SQLException e) {
                        throw new RuntimeException("Bad getTimestap");
                    }
                }

                @Override
                public void setTimeStamp(long timeStamp) {
                    try {
                        setTimeStamp.setLong(1, timeStamp);
                        setTimeStamp.setLong(2, id);
                        setTimeStamp.execute();
                    } catch (SQLException e) {
                        // TODO
                        throw new RuntimeException("Bad setTimestamp");
                    }
                }

                @Override
                public String getSender() {
                    return runPreparedGetString(getSender, id);
                }

                @Override
                public void setSender(String sender) {
                    try{
                        setSender.setString(1, sender);
                        setSender.setLong(2, id);
                        setSender.execute();
                    }catch (SQLException e){
                        // TODO
                        throw new RuntimeException("Bad setSender");
                    }
                }
            };
            return im[0];
        }catch (SQLException ee){
            // TODO
            ee.printStackTrace();
            return null;
        }
    }

    private String runPreparedGetString(PreparedStatement ps, long id){
        try {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);
        }catch (SQLException e){
            // TODO
            return "**SERVER ERROR**";
        }
    }

    public ImageMetadata addImageMetadata(){
        return null;
    }

    public List<ImageMetadataMessage> getList(){
        List<ImageMetadataMessage> imm = new ArrayList<>();
        ConnectionManager.getConnectionManager().useConnectionNow(con -> {
            try {
                PreparedStatement ps = con.prepareStatement("SELECT id FROM ImageMetadata");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    imm.add(getImageMetadata(rs.getInt(1), con).getMessage());
                }
            }catch (SQLException ee){
                ee.printStackTrace();
                // oops
                throw new RuntimeException("BAD SELECT");
            }
        });

        return imm;
    }
}
