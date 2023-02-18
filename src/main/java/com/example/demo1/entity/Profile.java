package com.example.demo1.entity;

import com.example.demo1.model.ProfileData;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue
    private Long id;
    private String profileName;
    private String profilePicture;
    private  String profileSecret;
@OneToOne
@JoinColumn(name = "user_id")
    private User user;


    public Profile entityToDto(){
        Profile profile = new Profile();
        profile.setProfileName(profileName);
        profile.setProfilePicture(profilePicture);
        return profile;
    }

}
