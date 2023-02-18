package com.example.demo1.model;

import com.example.demo1.entity.Profile;
import com.example.demo1.entity.User;
import lombok.Data;

@Data
public class ProfileData {
    private Long id;
    private String profileName;
    private String profilePicture;
    private User user;


    public  Profile dtoToEntity(ProfileData profileData){
        Profile pr=new Profile();
        pr.setProfileName(profileData.getProfileName());
        pr.setProfilePicture(profileData.getProfilePicture());
        pr.setUser(user);
        return  pr;
    }

}
