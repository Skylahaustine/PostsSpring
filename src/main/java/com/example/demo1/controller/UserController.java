package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import com.example.demo1.service.UserService;
import com.example.demo1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")

    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<User>(
                userService.createUser(user), HttpStatus.CREATED
        );

    }
@PostMapping("/userwithposts")
public ResponseEntity<User> saveUserWithPosts (@RequestBody User user){
        return new ResponseEntity<User>(
                userService.createUserWithPosts(user), HttpStatus.CREATED);
}

@GetMapping("/user")
    public List<User> getAllUsers (){

        return userService.fetchAllUsers();
}
}
