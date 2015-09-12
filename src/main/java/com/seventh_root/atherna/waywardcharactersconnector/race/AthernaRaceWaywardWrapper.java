package com.seventh_root.atherna.waywardcharactersconnector.race;

import net.wayward_realms.waywardlib.character.Race;
import net.wayward_realms.waywardlib.classes.Stat;

import java.util.HashMap;
import java.util.Map;

public class AthernaRaceWaywardWrapper implements Race {

    private String athernaRace;

    public AthernaRaceWaywardWrapper(String athernaRace) {
        this.athernaRace = athernaRace;
    }

    @Override
    public String getName() {
        return athernaRace;
    }

    @Override
    public int getStatBonus(Stat stat) {
        return 0;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> serialised = new HashMap<>();
        serialised.put("name", getName());
        return serialised;
    }
}
