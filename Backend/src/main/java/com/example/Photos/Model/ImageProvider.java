package com.example.Photos.Model;

import com.example.Photos.Presentation.ImageMetadata;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public interface ImageProvider {
    public List<ImageMetadata> getImageMetadata(Integer pageNumber, Integer numberOfItemsPerPage);
    public BufferedImage getImage(int id, int width, int height);
    default byte[] convertImageToByteArray(BufferedImage bi, String format) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, bos);
        return bos.toByteArray();
    }
}
