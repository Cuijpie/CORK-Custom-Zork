package command;

import dictionary.GameEntities;
import entity.*;

import java.util.Set;

public class ListContents extends Command {
    private IInteractable parent;
    private Set<String> args;

    public ListContents(final Set<String> args, final IInteractable parent) {
        this.args = args;
        this.parent = parent;
    }

    @Override
    public String apply(final String object, final GameEntities ge)
    {
        if (!(parent instanceof ICharacter)) { return "You cannot do that."; }

        final ICharacter p = (ICharacter) parent;

        StringBuilder contents = new StringBuilder("Contents: ");

        for (final String item : p.getInventory()) { contents.append(item).append(", "); }

        if (!p.getInventory().isEmpty()) { contents.delete(contents.length() - 2, contents.length()); }

        return contents.toString();
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