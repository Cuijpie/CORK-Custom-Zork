package entity;

import java.util.HashSet;
import java.util.Set;

public class Npc extends Entity implements ICharacter {
    private String type;
    private String name;
    private String description;
    private Set<String> inventory;
    private Boolean active;
    private Stat stat;

    public Npc(String type,
               String name,
               String description,
               Set<String> inventory,
               Boolean active,
               Stat stat) {

        this.type = type;
        this.name = name;
        this.description = description;
        this.inventory = new HashSet<>(inventory);
        this.active = active;
        this.stat = stat;
    }

    @Override
    public String getType() { return type; }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Boolean isActive() { return active; }

    @Override
    public Set<String> getInventory() { return new HashSet<>(inventory); }

    @Override
    public void addToInventory(String object) { inventory.add(object); }

    @Override
    public void removeFromInventory(String object) { inventory.remove(object); }

    @Override
    public boolean hasInInventory(String object) { return inventory.contains(object); }

    public Stat getStat() { return stat; }
}
