package com.luv2code.springboot.demo.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // Reading custom properties, injecting properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    //expose new endpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return coachName + "  " + teamName;
    }

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
