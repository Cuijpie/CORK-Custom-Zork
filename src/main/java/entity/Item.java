package entity;

import command.Command;
import command.DefaultCommand;

public class Item extends Entity {
    private String type;
    private String name;
    private String description;
    private Boolean consumable;
    private Boolean active;
    private Stat stat;

    public Item(String type,
                String name,
                String description,
                Boolean consumable,
                Boolean active,
                Stat stat) {

        this.type = type;
        this.name = name;
        this.description = description;
        this.consumable = consumable;
        this.active = active;
        this.stat = stat;
    }

    @Override
    public String getType() { return type; }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Boolean isActive() { return active; }

    @Override
    public Command findCommandOrElse(String cmd) {
        return new DefaultCommand();
    }

    public Boolean isConsumable() { return consumable; }

    public Stat getStat() { return stat; }

}


