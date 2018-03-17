package com.example.Photos.Controller;

import com.example.Photos.Model.ImageProvider;
import com.example.Photos.Presentation.ImageMetadata;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
public class ImageController {

    @Inject
    private ImageProvider imageProvider;

    @RequestMapping(
            value = "/images",
            method = RequestMethod.GET,
            produces = "application/json")
    public String getImagesWithPages(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer numberOfItemsPerPage){
        Gson g = (new GsonBuilder().setPrettyPrinting().create());
        return g.toJson(imageProvider.getImageMetadata(pageNumber, numberOfItemsPerPage));
    }

    @RequestMapping(
            value="/images/{id}-{width}x{height}.{format}",
            method = RequestMethod.GET,
            produces = "image/jpeg")
    public byte[] getImage(@PathVariable int id, @PathVariable int width, @PathVariable int height, @PathVariable String format, HttpServletResponse response){
        format = format.toLowerCase();
        if(format.equals("jpg")|format.equals("jpeg")|format.equals("png")) {
            try {
                return imageProvider.convertImageToByteArray(imageProvider.getImage(id, width, height), format);
            }catch (Exception e){
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return new byte[0];
            }
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_ACCEPTABLE);
            return new byte[0];
        }
    }
}
