package com.example.demo1.controller;

import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import com.example.demo1.service.UserService;
import com.example.demo1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }
    @PostMapping("/User")

    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<User>(
                userService.createUser(user), HttpStatus.CREATED
        );


    }



}
