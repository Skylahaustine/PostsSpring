package com.example.demo1.service;

import com.example.demo1.model.UserData;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserData createUser(UserData userData);
}
