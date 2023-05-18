package com.hrutility.hrutilityjava.controller;

import com.hrutility.hrutilityjava.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "hello there";
    }

    @GetMapping("/user")
    public User user(){
        User user = new User();
        user.setId("1");
        user.setName("Dinesh Karki");
        user.setEmailId("dinesh.karki@yopmail.com");

        return user;
    }
    @GetMapping("user/{id}")
    public String pathVariable(@PathVariable String id){
    return "The path variable is: " + id;
    }

    @GetMapping("/requestParams")
    public String requestParams(@RequestParam String name){
        return "Your name is: " + name;
    }
}
