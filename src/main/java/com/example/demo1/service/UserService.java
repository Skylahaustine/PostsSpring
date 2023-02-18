package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);
    ResponseEntity<UserData> createUser(UserData userData);
    ResponseEntity<UserData> fetchById(UserData userData);

    User createUserWithPosts(User user);

    List<User> fetchAllUsers();

}
