package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * ShowAllAction
 */
public class ShowAllAction implements UserAction {
    private final Output out;

    /**
     * showAllAction
     * @param out test
     */
    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Show all items ====");
        List<Item> items = tracker.findAll();
        for (Item it : items) {
            out.println(it.getId() + "." + it.getName());
        }
        return true;
    }
}
