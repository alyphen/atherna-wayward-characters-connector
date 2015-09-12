package com.seventh_root.atherna.waywardcharactersconnector;

import com.seventh_root.atherna.Atherna;
import com.seventh_root.atherna.character.AthernaCharacter;
import com.seventh_root.atherna.player.AthernaPlayer;
import com.seventh_root.atherna.waywardcharactersconnector.character.AthernaCharacterWaywardWrapper;
import com.seventh_root.atherna.waywardcharactersconnector.gender.AthernaGenderWaywardWrapper;
import com.seventh_root.atherna.waywardcharactersconnector.race.AthernaRaceWaywardWrapper;
import net.wayward_realms.waywardlib.character.Character;
import net.wayward_realms.waywardlib.character.*;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class AthernaWaywardCharactersConnector extends JavaPlugin implements CharacterPlugin {

    private Map<String, Gender> genders;
    private Race dummyRace;

    @Override
    public void onEnable() {
        genders = new HashMap<>();
        dummyRace = new AthernaRaceWaywardWrapper("");
    }

    @Override
    public net.wayward_realms.waywardlib.character.Character getActiveCharacter(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        return new AthernaCharacterWaywardWrapper(this, atherna.getPlayerManager().getByBukkitPlayer(player).getActiveCharacter());
    }

    @Override
    public void setActiveCharacter(Player player, Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        atherna.getPlayerManager().getByBukkitPlayer(player).setActiveCharacter(atherna.getCharacterManager().getById(character.getId()));
    }

    @Override
    public Collection<? extends Character> getCharacters(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        List<AthernaCharacter> athernaCharacters = atherna.getCharacterManager().getByPlayer(atherna.getPlayerManager().getByBukkitPlayer(player));
        List<AthernaCharacterWaywardWrapper> waywardWrappers = new ArrayList<>();
        athernaCharacters.forEach(athernaCharacter -> waywardWrappers.add(new AthernaCharacterWaywardWrapper(this, athernaCharacter)));
        return waywardWrappers;
    }

    @Override
    public void addCharacter(OfflinePlayer player, Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        athernaCharacter.setPlayer(athernaPlayer);
    }

    @Override
    public void removeCharacter(OfflinePlayer player, Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        athernaCharacter.setPlayer(null);
    }

    @Override
    public void removeCharacter(Character character) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().getById(character.getId());
        athernaCharacter.delete();
    }

    @Override
    public Character createNewCharacter(OfflinePlayer player) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        AthernaPlayer athernaPlayer = atherna.getPlayerManager().getByBukkitPlayer(player);
        AthernaCharacter athernaCharacter = atherna.getCharacterManager().createDefaultCharacter();
        athernaCharacter.setPlayer(athernaPlayer);
        return new AthernaCharacterWaywardWrapper(this, athernaCharacter);
    }

    @Override
    public Character getCharacter(int id) {
        Atherna atherna = (Atherna) getServer().getPluginManager().getPlugin("atherna");
        return new AthernaCharacterWaywardWrapper(this, atherna.getCharacterManager().getById(id));
    }

    @Override
    public Collection<? extends Race> getRaces() {
        Set<Race> races = new HashSet<>();
        races.add(dummyRace);
        return races;
    }

    @Override
    public Race getRace(String name) {
        return dummyRace;
    }

    @Override
    public void addRace(Race race) {

    }

    @Override
    public void removeRace(Race race) {

    }

    @Override
    public Collection<? extends Gender> getGenders() {
        return genders.values();
    }

    @Override
    public Gender getGender(String name) {
        if (!genders.containsKey(name))
            genders.put(name, new AthernaGenderWaywardWrapper(name));
        return genders.get(name);
    }

    @Override
    public void addGender(Gender gender) {
        genders.put(gender.getName(), gender);
    }

    @Override
    public void removeGender(Gender gender) {
        genders.remove(gender.getName());
    }

    @Override
    public int getNextAvailableId() {
        return 0;
    }

    @Override
    public void setNextAvailableId(int id) {

    }

    @Override
    public void incrementNextAvailableId() {

    }

    @Override
    public Party getParty(Character character) {
        return null;
    }

    @Override
    public String getPrefix() {
        return "";
    }

    @Override
    public void loadState() {

    }

    @Override
    public void saveState() {

    }

}
