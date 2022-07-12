package com.example.day3assigngreetingappdevelopment.controller;

import com.example.day3assigngreetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CreatingController {
    //UC1
//    @RequestMapping("/hello")
//    public String Hello() {
//        return "hello From Bridgelabz";
//    }
//
//    @RequestMapping("/query/{name}")
//    public String sayHello(@PathVariable String name) {
//        return "Hello " + name + "!";
//    }

//    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
//    public String sayHelloParam(@RequestParam(value = "name") String name) {
//        return "Hello " + name + "!";
//    }
//
    //UC2
    public static final String template = "Hello & Welcome to the greeting app, %s";
    public final AtomicLong counter = new AtomicLong();
    @Autowired
    public GreetingService service;

    @GetMapping("/greetingsWithUser")
    public String greetingWithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return service.greetingWithUserName(firstName, lastName);
    }
}