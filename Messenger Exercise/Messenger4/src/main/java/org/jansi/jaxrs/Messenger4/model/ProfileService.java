package org.jansi.jaxrs.Messenger4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jansi.jaxrs.Messenger4.database.DatabaseClass;

public class ProfileService {
	
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	
	public ProfileService() {
		profiles.put("jansi", new Profile(1L, "Jansi", "Jansi", "Rani"));
		profiles.put("sri", new Profile(2L, "sri", "Sri", "Kanth"));
	}
	
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;

	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}


}
