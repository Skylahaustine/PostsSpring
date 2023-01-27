package com.example.demo1.service;

import com.example.demo1.entity.User;
import com.example.demo1.model.UserData;
import com.example.demo1.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    private final UserRepo userrepo;
    @Autowired
    public UserServiceImpl(UserRepo userrepo){
        this.userrepo=userrepo;
    }
    @Override
    public UserData createUser(UserData userdata) {
        User user = new User();

        BeanUtils.copyProperties(userdata, user);
        return  userdata;

    }
}
