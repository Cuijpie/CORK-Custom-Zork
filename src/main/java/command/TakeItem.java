package command;

import dictionary.GameEntities;
import entity.*;

import java.util.Map;
import java.util.Set;

public class TakeItem extends Command {
    private IInteractable parent;
    private Set<String> args;

    public TakeItem(final Set<String> args, final IInteractable parent) {
        this.args = args;
        this.parent = parent;
    }

    @Override
    public String apply(String object, GameEntities ge) {
        if (!(parent instanceof ICharacter)) { return "You cannot do that."; }

        Area area = ge.getAreaOrElse(parent.getCurrentLocation());

        if (!area.hasInInventory(object)) { return String.format("You cannot pick up '%s'", object); }

        area.removeFromInventory(object);

        StringBuilder result = new StringBuilder(object + " -> " + parent.getName());

        ICharacter p = (ICharacter) parent;
        p.addToInventory(object);

        Item i = ge.getItemOrElse(object);

        if (i.isConsumable()) { return result.toString(); }

        for (final Map.Entry<String, Integer> stat : i.getStats().entrySet())
        {
            final Integer oldValue = p.getStatValue(stat.getKey());
            final Integer newValue = oldValue + stat.getValue();
            p.setStat(stat.getKey(), newValue);

            result.append("\n").append(stat.getKey()).append(" changes to ").append(newValue);
        }

        return result.toString();
    }

    public String apply(final Area object, final GameEntities ge) {
        return "";
    }

    public String apply(final Item object, final GameEntities ge) {
        return "";
    }

    public String apply(final Npc object, final GameEntities ge) {
        return "";
    }

    public String apply(final Obstacle object, final GameEntities ge) {
        return "";
    }

    public String apply(final Player object, final GameEntities ge) {
        return "";
    }
}