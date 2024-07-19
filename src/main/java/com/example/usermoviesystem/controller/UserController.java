package com.example.usermoviesystem.controller;

import com.example.usermoviesystem.model.User;
import com.example.usermoviesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user){
        boolean added = userService.addUser(user);
        if (added) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("get/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @CrossOrigin("*")
    @GetMapping("getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("updateName/{id}")
    public User updateNameById(@PathVariable int id, @RequestBody String name) {
        User u = null;
        u = userService.updateNameById(id, name);
        return u;
    }

    @CrossOrigin("*")
    @DeleteMapping("delete/{id}")
    public boolean deleteUserById(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
