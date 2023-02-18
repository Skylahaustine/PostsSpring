package com.example.demo1.service;

import com.example.demo1.entity.Profile;
import com.example.demo1.model.ProfileData;
import com.example.demo1.repository.ProfileRepo;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepo profileRepo;

    public ProfileServiceImpl(ProfileRepo profileRepo) {
        this.profileRepo = profileRepo;
    }

    @Override
    public Profile createProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public List<Profile> fetchAllProfiles() {
        return profileRepo.findAll();
    }


//    public Profile fetchProfileById(long profileId) {
////        return null;
//        Optional<Profile> profile = profileRepo.findById(profileId);
//
//        if (profile.isPresent()) {
////            return profile.get().entityToDto();
//        } else {
//            return null;
//        }
//    }

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
    public Profile updateProfileById(Profile profile, long id) {
        Profile existingProfile = profileRepo.findById(id).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("Profile", "Id", "id")

        );
        existingProfile.setProfileName(profile.getProfileName());
        profileRepo.save(existingProfile);
        return existingProfile;
    }

    @Override
    public void deleteProfile(long id) {
        profileRepo.findById(id).orElseThrow(
                () -> new InvalidConfigurationPropertyValueException("ProfIle", "Id", "id"));
        profileRepo.deleteById(id);

    }
}
