package com.example.demo1.model;

import com.example.demo1.entity.User;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private Long id;
    private String userName;
    private String otherName;

    private ProfileData profileData;


//    public User toEntity() {
//        User user = new User();
//        user.setUserName(this.getUserName());
//        return user;
//
//
//    }

}


