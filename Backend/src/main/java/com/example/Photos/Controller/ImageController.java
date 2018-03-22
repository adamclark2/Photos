package com.example.Photos.Controller;

import com.example.Photos.Model.ImageProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Should be generating images...");
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

    /**
     * Return a list of strings, which are URLs to actual images stored somewhere.  This is a dumb method for
     * testing purposes lol.
     * @return a list of strings, in JSON formatS
     */
    @RequestMapping(
            value = "/imageurls",
            method = RequestMethod.GET,
            produces = "application/json")
    public String getImagesWithUrls(){
        Gson g = (new GsonBuilder().setPrettyPrinting().create());

        // *** FOR TESTING LOL ***

        List<String> testUrls = new ArrayList<>();
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");
        testUrls.add("http://10.0.2.2:8080/images/1-500x500.jpg");

        return g.toJson(testUrls);

        //Using a service, we create a list of the URLs of all the images, and return them to caller
        //ImageService imageService = new ImageService();
        //List<String> imageUrls = imageService.getAllImageUrls();
        //return g.toJson(imageUrls);
    }
}
