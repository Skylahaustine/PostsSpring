package com.example.demo1.model;

import com.example.demo1.entity.User;

public class UserData {
    private Long id;
    private String userName;


    public User toEntity(){
        User user = new User();
        user.setUserName(this.getUserName());




    }

}
