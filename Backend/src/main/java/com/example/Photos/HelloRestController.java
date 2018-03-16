package com.example.Photos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
