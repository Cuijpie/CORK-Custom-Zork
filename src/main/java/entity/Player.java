package entity;

import command.*;
import deserialiser.CommandBlueprint;

import java.util.*;

public class Player extends Entity implements ICharacter, IInteractable {
    private String type;
    private String name;
    private String description;
    private Set<String> inventory;
    private Boolean active;
    private String currentLocation;
    private Map<String, Integer> stats;
    private Set<CommandBlueprint> commands;

    private Map<String, Command> actions;

    public Player(String type, // NOSONAR - 8 parameters are required to allow deserialization
                  String name,
                  String description,
                  List<String> inventory,
                  Boolean active,
                  String currentLocation,
                  Map<String, Integer> stats,
                  List<CommandBlueprint> commands) {

        this.type = type;
        this.name = name;
        this.description = description;
        this.inventory = new HashSet<>(inventory);
        this.active = active;
        this.currentLocation = currentLocation;
        this.stats = stats;
        this.commands = new HashSet<>(commands);
        this.actions = null;
    }

    @Override
    public String getType() { return type; }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public boolean isActive() { return active; }

    @Override
    public void setActive(boolean value) { active = value; }

    @Override
    public Set<String> getInventory() { return new HashSet<>(inventory); }

    @Override
    public void addToInventory(final String object) { inventory.add(object); }

    @Override
    public void removeFromInventory(String object) { inventory.remove(object); }

    @Override
    public boolean hasInInventory(String object) { return inventory.contains(object); }

    @Override
    public Set<CommandBlueprint> getCommands() { return new HashSet<>(commands); }

    @Override
    public void setCurrentLocation(String newLocation) {
        currentLocation = newLocation;
    }

    @Override
    public String getCurrentLocation() { return currentLocation; }

    public Map<String, Integer> getStats() { return stats; }

    @Override
    public void setStat(String name, Integer value) { stats.replace(name, value); }

    @Override
    public Integer getStatValue(String name) { return stats.getOrDefault(name, 0); }

    public void setActions(Map<String, Command> actions) {
        this.actions = actions;
    }

    @Override
    public Command findCommandOrElse(String cmd) {
        return actions.getOrDefault(cmd, new DefaultCommand());
    }

    public boolean has(String item) { return inventory.contains(item); }

    public boolean isDead() { return (stats.getOrDefault("health", 0) <= 0); }
}

