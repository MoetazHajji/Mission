package com.example.mission.controller;

import com.example.mission.entities.User;
import com.example.mission.services.IMymissionService;
import com.example.mission.services.IUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public User addUser(@RequestBody User user){
        return userService.ajouterUser(user);
    }

    @GetMapping("getByName/{name}")
    public User getByName(@PathVariable("name") String name){
        return userService.getByName(name);
    }

}
