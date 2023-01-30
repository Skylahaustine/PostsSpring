package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userrepo;

    public UserServiceImpl(UserRepo userrepo) {
        this.userrepo = userrepo;
    }

    @Override
    public User createUser(User user) {
        return userrepo.save(user);

    }
}
