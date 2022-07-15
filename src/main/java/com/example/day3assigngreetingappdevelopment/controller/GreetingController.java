package com.example.day3assigngreetingappdevelopment.controller;

import com.example.day3assigngreetingappdevelopment.model.Greeting;
import com.example.day3assigngreetingappdevelopment.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    //UC1
   @RequestMapping("/hello")
   public String Hello() {
      return "hello From Bridgelabz";
    }

   @RequestMapping("/query/{name}")
    public String sayHello(@PathVariable String name) {
       return "Hello " + name + "!";
   }

   @RequestMapping(value = {"/query"}, method = RequestMethod.GET)
    public String sayHelloParam(@RequestParam(value = "name") String name) {
       return "Hello " + name + "!";
    }
    public static final String template = "Hello & Welcome to the greeting app, %s";
    public final AtomicLong counter = new AtomicLong();
    @Autowired
    public GreetingService service;

    //UC2
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }
    @RequestMapping("/welcome")

    public String displayMessage(){
        return service.greetingMessage();
    }

    //UC3
    @GetMapping("/greetingsWithUser")
    public String greetingWithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return service.greetingWithUserName(firstName, lastName);
    }

    //UC4
    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting){
        return service.saveGreetings(greeting);
    }

    //UC5
    @GetMapping("/greetingById/{id}")
    public Greeting getGreetingById(@PathVariable Integer id){
        return service.findGreetingById(id);
    }

}