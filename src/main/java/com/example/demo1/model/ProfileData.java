package com.example.demo1.model;

import com.example.demo1.entity.Profile;
import lombok.Data;

@Data
public class ProfileData {
    private Long id;
    private String profileName;
    private String profilePicture;


    public  Profile dtoToEntity( ProfileData profileData){
        Profile pr=new Profile();
        pr.setProfileName(profileData.getProfileName());
        pr.setProfilePicture(pr.getProfilePicture());
        return  pr;
    }

}
