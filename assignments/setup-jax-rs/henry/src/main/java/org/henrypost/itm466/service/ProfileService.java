package org.henrypost.itm466.service;

import org.henrypost.itm466.database.DatabaseClass;
import org.henrypost.itm466.model.Profile;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {
    private Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        if (getAllProfiles().size() <= 0) {
            addProfile(new Profile(-1L, "TestUser123", "Test", "Man"));
            addProfile(new Profile(-1L, "JavaMaster", "Java", "God"));
        }
    }


    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName) {

        if (!profiles.containsKey(profileName)) {
            throw new WebApplicationException("No profile by that name exists!", Response.Status.BAD_REQUEST);
        }

        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId((long) (profiles.size() + 1));

        if (profiles.containsKey(profile.getProfileName())) {
            throw new WebApplicationException("Profile with that name already exists!", Response.Status.BAD_REQUEST);
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getId() < 0) {
            throw new WebApplicationException("Profile ID cannot be less than 0!", Response.Status.BAD_REQUEST);
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
