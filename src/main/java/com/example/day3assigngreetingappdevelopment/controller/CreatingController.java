package com.example.day3assigngreetingappdevelopment.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CreatingController {
    //UC1
    @RequestMapping("/hello")
    public String Hello(){
        return "hello From Bridgelabz";
    }

    @RequestMapping ("/query/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloParam(@RequestParam(value = "name") String name)
    {
        return "Hello " + name + "!";
    }
}
