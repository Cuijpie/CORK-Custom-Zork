package command;

import dictionary.GameEntities;
import entity.IInteractable;

import java.util.Set;

public class ListContents extends Command {
    private IInteractable parent; // NOSONAR
    private Set<String> args;

    public ListContents(Set<String> args, IInteractable parent) {
        this.args = args;
        this.parent = parent;
    }

    @Override
    public String apply(String object, GameEntities ge) {
        return "Action>>>$ "+ "List contents of " + args;
    }
}