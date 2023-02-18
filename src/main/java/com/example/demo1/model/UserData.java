package com.example.demo1.model;

import com.example.demo1.entity.User;
import lombok.*;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserData {
    private Long id;
    private String userName;
    private String otherName;

    private ProfileData profileData;

    private List<PostData> postData;


//    public User toEntity() {
//        User user = new User();
//        user.setUserName(this.getUserName());
//        return user;
//
//
//    }

}


