package org.urfu.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.urfu.Models.User;

@RestController
public class Controller {

    @GetMapping("/ums")
    public String getUms(){
        return "hello";
    }

    @PostMapping("/ums")
    public String createUser(@RequestBody User user){
        return user.toString();
    }

    @PostMapping("/ums")
    public String putUser(User user){
        return "";
    }

    @PostMapping("/ums")
    public String deleteUser(String id){
        return "";
    }
}
