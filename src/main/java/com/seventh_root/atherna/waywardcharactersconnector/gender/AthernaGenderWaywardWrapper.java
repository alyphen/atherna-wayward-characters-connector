package com.seventh_root.atherna.waywardcharactersconnector.gender;

import net.wayward_realms.waywardlib.character.Gender;

import java.util.HashMap;
import java.util.Map;

public class AthernaGenderWaywardWrapper implements Gender {

    private String athernaGender;

    public AthernaGenderWaywardWrapper(String athernaGender) {
        this.athernaGender = athernaGender;
    }

    @Override
    public String getName() {
        return athernaGender;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialised = new HashMap<>();
        serialised.put("name", getName());
        return serialised;
    }

}
