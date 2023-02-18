package com.example.demo1.entity;

import com.example.demo1.model.ProfileData;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profileName;
    private String profilePicture;
    private  String profileSecret;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public ProfileData entityToDto() {
        ProfileData profileData = new ProfileData();
        profileData.setProfileName(profileName);
        profileData.setProfilePicture(profilePicture);
        return profileData;
    }


}
