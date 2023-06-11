package com.luv2code.springboot.demo.myfirstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Expose a '/' endpoint to return "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!!";
    }

    //expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "Today is a lucky day!!!";
    }

}
