package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User createUser(User user);


    User createUserWithPosts(User user);

    List<User> fetchAllUsers();

}
