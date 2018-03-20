package com.example.Photos.Model;

import com.example.Photos.Presentation.ImageMetadata;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InMemoryImageProvider implements ImageProvider {
    @Override
    public List<ImageMetadata> getImageMetadata(Integer pageNumber, Integer numberOfItemsPerPage) {
        ArrayList<ImageMetadata> arr = new ArrayList<>();

        for(int i = 0; i < 200;i++){
            arr.add(new ImageMetadata(i, "Some Cool abstract image", "images/" + i + "500x500.jpg"));
        }

        if(pageNumber == null || numberOfItemsPerPage ==  null){
            // No restrictions
            // Who knew a number could be null ... :D
            return arr;
        }

        if((pageNumber + 1) * numberOfItemsPerPage > arr.size()){
            // partial page
            if((pageNumber * numberOfItemsPerPage) < arr.size()){
                return arr.subList(pageNumber * numberOfItemsPerPage, arr.size());
            }

            // empty list ... ran past list
            return new ArrayList<>();
        }else{
            return arr.subList((pageNumber * numberOfItemsPerPage), (pageNumber + 1) * numberOfItemsPerPage);
        }
    }

    @Override
    public BufferedImage getImage(int id, int width, int height) {
        Random r = new Random(id);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = bi.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,width, height);

        int bound = r.nextInt(60);
        for(int i = 0; i < bound;i++){
            int x = r.nextInt(width);
            int y = r.nextInt(height);
            int widthOfRect = r.nextInt(width - x);
            int heightOfRect = r.nextInt(height - y);

            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.fillRect(x, y, widthOfRect, heightOfRect);
        }

        return bi;
    }
}
