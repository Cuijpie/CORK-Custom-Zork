package entity;

import command.Command;
import command.DefaultCommand;
import deserialiser.CommandBlueprint;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class EmptyEntity extends Entity implements ICharacter, IInteractable {
    private static final EmptyEntity EmptyEntityInstance = new EmptyEntity();

    private EmptyEntity(){}

    public static EmptyEntity initializeEmptyEntity(){
        return EmptyEntityInstance;
    }

    @Override
    public String getType() { return "EmptyEntity"; }

    @Override
    public String getName() {
        return "EmptyEntity";
    }

    @Override
    public String getDescription() {
        return "You cannot find that here.";
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void setActive(boolean value)
    {
        // Do nothing
    }

    @Override
    public Set<String> getInventory() {
        return Collections.emptySet();
    }

    @Override
    public void addToInventory(String object) {
        // Do nothing
    }

    @Override
    public void removeFromInventory(String object) {
        // Do nothing
    }

    @Override
    public boolean hasInInventory(String object) { return false; }

    @Override
    public Map<String, Integer> getStats() { return Collections.emptyMap(); }

    @Override
    public void setStat(String name, Integer value) {
        // Do nothing
    }

    @Override
    public Integer getStatValue(String name) { return 0; }

    @Override
    public String getCurrentLocation() {
        return "";
    }

    @Override
    public void setCurrentLocation(String newLocation) {
        // Do nothing
    }

    @Override
    public Set<CommandBlueprint> getCommands() {
        return Collections.emptySet();
    }

    @Override
    public Command findCommandOrElse(String cmd) {
        return new DefaultCommand();
    }
}
