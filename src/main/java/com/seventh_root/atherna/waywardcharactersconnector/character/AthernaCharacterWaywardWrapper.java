package com.seventh_root.atherna.waywardcharactersconnector.character;

import com.seventh_root.atherna.Atherna;
import com.seventh_root.atherna.character.AthernaCharacter;
import com.seventh_root.atherna.player.AthernaPlayer;
import com.seventh_root.atherna.waywardcharactersconnector.AthernaWaywardCharactersConnector;
import net.wayward_realms.waywardlib.character.Gender;
import net.wayward_realms.waywardlib.character.Race;
import net.wayward_realms.waywardlib.character.TemporaryStatModification;
import net.wayward_realms.waywardlib.classes.Stat;
import net.wayward_realms.waywardlib.skills.SkillType;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.HashSet;

public class AthernaCharacterWaywardWrapper implements net.wayward_realms.waywardlib.character.Character {

    private AthernaWaywardCharactersConnector plugin;
    private AthernaCharacter athernaCharacter;

    public AthernaCharacterWaywardWrapper(AthernaWaywardCharactersConnector plugin, AthernaCharacter athernaCharacter) {
        this.plugin = plugin;
        this.athernaCharacter = athernaCharacter;
    }

    @Override
    public int getId() {
        return athernaCharacter.getId();
    }

    @Override
    public String getName() {
        return athernaCharacter.getName();
    }

    @Override
    public void setName(String name) {
        athernaCharacter.setName(name);
    }

    @Override
    public boolean isNameHidden() {
        return athernaCharacter.isNameHidden();
    }

    @Override
    public void setNameHidden(boolean hidden) {
        athernaCharacter.setNameHidden(hidden);
    }

    @Override
    public int getAge() {
        return athernaCharacter.getAge();
    }

    @Override
    public void setAge(int age) {
        athernaCharacter.setAge(age);
    }

    @Override
    public boolean isAgeHidden() {
        return athernaCharacter.isAgeHidden();
    }

    @Override
    public void setAgeHidden(boolean hidden) {
        athernaCharacter.setAgeHidden(hidden);
    }

    @Override
    public Gender getGender() {
        return plugin.getGender(athernaCharacter.getGender());
    }

    @Override
    public void setGender(Gender gender) {
        athernaCharacter.setGender(gender.getName());
    }

    @Override
    public boolean isGenderHidden() {
        return athernaCharacter.isGenderHidden();
    }

    @Override
    public void setGenderHidden(boolean hidden) {
        athernaCharacter.setGenderHidden(hidden);
    }

    @Override
    public Race getRace() {
        return plugin.getRace("");
    }

    @Override
    public void setRace(Race race) {

    }

    @Override
    public boolean isRaceHidden() {
        return true;
    }

    @Override
    public void setRaceHidden(boolean hidden) {

    }

    @Override
    public String getDescription() {
        return athernaCharacter.getDescription();
    }

    @Override
    public void setDescription(String info) {
        athernaCharacter.setDescription(info);
    }

    @Override
    public void addDescription(String info) {
        athernaCharacter.setDescription(athernaCharacter.getDescription() + info);
    }

    @Override
    public boolean isDescriptionHidden() {
        return athernaCharacter.isDescriptionHidden();
    }

    @Override
    public void setDescriptionHidden(boolean hidden) {
        athernaCharacter.setDescriptionHidden(hidden);
    }

    @Override
    public OfflinePlayer getPlayer() {
        return athernaCharacter.getPlayer().getBukkitPlayer();
    }

    @Override
    public void setPlayer(OfflinePlayer bukkitPlayer) {
        Atherna atherna = (Atherna) plugin.getServer().getPluginManager().getPlugin("atherna");
        if (atherna != null) {
            AthernaPlayer player = atherna.getPlayerManager().getByBukkitPlayer(bukkitPlayer);
            if (player != null) {
                athernaCharacter.setPlayer(player);
            }
        }
    }

    @Override
    public double getHealth() {
        return athernaCharacter.getHealth();
    }

    @Override
    public void setHealth(double health) {
        athernaCharacter.setHealth(health);
    }

    @Override
    public int getFoodLevel() {
        return athernaCharacter.getFoodLevel();
    }

    @Override
    public void setFoodLevel(int foodLevel) {
        athernaCharacter.setFoodLevel(foodLevel);
    }

    @Override
    public int getThirst() {
        return 20;
    }

    @Override
    public void setThirst(int thirstLevel) {

    }

    @Override
    public double getMaxHealth() {
        return athernaCharacter.getMaxHealth();
    }

    @Override
    public int getMana() {
        return athernaCharacter.getMana();
    }

    @Override
    public void setMana(int mana) {
        athernaCharacter.setMaxMana(mana);
    }

    @Override
    public int getMaxMana() {
        return athernaCharacter.getMaxMana();
    }

    @Override
    public Location getLocation() {
        return athernaCharacter.getLocation();
    }

    @Override
    public void setLocation(Location location) {
        athernaCharacter.setLocation(location);
    }

    @Override
    public ItemStack getHelmet() {
        return null;
    }

    @Override
    public void setHelmet(ItemStack helmet) {

    }

    @Override
    public ItemStack getChestplate() {
        return null;
    }

    @Override
    public void setChestplate(ItemStack chestplate) {

    }

    @Override
    public ItemStack getLeggings() {
        return null;
    }

    @Override
    public void setLeggings(ItemStack leggings) {

    }

    @Override
    public ItemStack getBoots() {
        return null;
    }

    @Override
    public void setBoots(ItemStack boots) {

    }

    @Override
    public ItemStack[] getInventoryContents() {
        return new ItemStack[0];
    }

    @Override
    public void setInventoryContents(ItemStack[] contents) {

    }

    @Override
    public boolean isDead() {
        return athernaCharacter.isDead();
    }

    @Override
    public void setDead(boolean dead) {
        athernaCharacter.setDead(dead);
    }

    @Override
    public int getStatValue(Stat stat) {
        return -3;
    }

    @Override
    public Collection<TemporaryStatModification> getTemporaryStatModifications() {
        return new HashSet<>();
    }

    @Override
    public void addTemporaryStatModification(TemporaryStatModification modification) {

    }

    @Override
    public void removeTemporaryStatModification(TemporaryStatModification modification) {

    }

    @Override
    public int getSkillPoints(SkillType type) {
        return 0;
    }

    @Override
    public boolean isClassHidden() {
        return true;
    }

    @Override
    public void setClassHidden(boolean hidden) {

    }

    @Override
    public String getNamePlate() {
        return athernaCharacter.getName();
    }

    @Override
    public void setNamePlate(String namePlate) {

    }
}
