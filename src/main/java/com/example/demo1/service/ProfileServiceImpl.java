package com.example.demo1.service;

import com.example.demo1.entity.Profile;
import com.example.demo1.model.ProfileData;
import com.example.demo1.repository.ProfileRepo;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public ResponseEntity<ProfileData> createProfile(ProfileData profiledata)
    {
        Profile profile = profiledata.dtoToEntity(profiledata);
        profileRepo.save(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body(profile.entityToDto());
    }

    @Override
    public ResponseEntity<List<ProfileData>> fetchAllProfiles() {
        List<Profile> profiles = profileRepo.findAll();
        List<ProfileData> profileDataList= profiles.stream()
                .map(Profile::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(profileDataList);


//
    }




@Override
    public ProfileData getProfileById(Long id) {
        Optional<Profile> profileOpt = profileRepo.findById(id);
        if (profileOpt.isPresent()) {
            Profile profile = profileOpt.get();
            return profile.entityToDto();
        } else {
            return null;
        }
    }


    @Override
    public ResponseEntity<ProfileData> updateProfileById(ProfileData profileData, long id) {
        Profile existingProfile = profileRepo.findById(id).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("Profile", "Id", "id")

        );
        existingProfile.setProfileName(profileData.getProfileName());
        existingProfile.setProfilePicture(profileData.getProfilePicture());
        profileRepo.save(existingProfile);
        return ResponseEntity.ok().body(existingProfile.entityToDto());
    }

    @Override
    public void deleteProfile(long id) {
        profileRepo.findById(id).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("ProfIle", "Id", "id"));
        profileRepo.deleteById(id);

    }
}
