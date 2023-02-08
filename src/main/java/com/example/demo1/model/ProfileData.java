package com.example.demo1.model;

import com.example.demo1.entity.Profile;
import lombok.Data;

@Data
public class ProfileData {
    private Long id;
    private String profileName;
    private String profilePicture;

    public ProfileData entityToDto(Profile profile){
        ProfileData profileDTo = new ProfileData();
        profileDTo.setProfileName(profile.getProfileName());
        profileDTo.setProfilePicture(profile.getProfilePicture());
        return profileDTo;
    }

}
