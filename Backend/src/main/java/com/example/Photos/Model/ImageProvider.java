package com.example.Photos.Model;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public interface ImageProvider {
    public List<ImageMetadata> getImageMetadata(Integer pageNumber, Integer numberOfItemsPerPage);

    /**
     * @deprecated
     * @param id
     * @param width
     * @param height
     * @return
     */
    public BufferedImage getImage(int id, int width, int height);

    /**
     * @deprecated
     * @param bi
     * @param format
     * @return
     * @throws IOException
     */
    default byte[] convertImageToByteArray(BufferedImage bi, String format) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, format, bos);
        return bos.toByteArray();
    }
}
