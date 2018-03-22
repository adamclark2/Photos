package com.example.Photos.Controller;

import com.example.Photos.Model.ImageProvider;
import com.example.Photos.Model.Messages.ImageMetadataMessage;
import com.example.Photos.Persistence.Model.ImageMetadataADRFactory;
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
    private ImageMetadataADRFactory adrFactory;

    @RequestMapping(
            value = "/images",
            method = RequestMethod.GET,
            produces = "application/json")
    public String getImagesWithPages(@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer numberOfItemsPerPage){
        Gson g = (new GsonBuilder().setPrettyPrinting().create());
        List<ImageMetadataMessage> l = adrFactory.getList();
        if(l==null){
            throw new RuntimeException("oops!!! null!");
        }
        return g.toJson(l);
    }

}
