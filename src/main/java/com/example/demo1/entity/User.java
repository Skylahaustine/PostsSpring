package com.example.demo1.entity;

import com.example.demo1.model.PostData;
import com.example.demo1.model.ProfileData;
import com.example.demo1.model.UserData;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "user_nam", nullable = false)
    private String userName;
    private String otherName;
    private  String userSecret;
    @OneToMany(mappedBy = "user" ,cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Posts> posts;



    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)

    private Profile profile;


    public UserData entityToDto (){

        UserData userDto  = new UserData();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setOtherName(otherName);
        if (profile != null) {
            userDto.setProfileData(profile.entityToDto());
        }
        if (posts != null) {
            List<PostData> postData = posts.stream()
                    .map(Posts::entityToDto)
                    .collect(Collectors.toList());
            userDto.setPostData(postData);
        }

        return  userDto;
    }

}
