package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * FindByNameAction
 */
public class FindByNameAction implements UserAction {
    private final Output out;

    /**
     * FindByNameAction
     * @param out test
     */
    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find items by name ====");
        String name = input.askStr("Enter name: ");
        ArrayList<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item it : items) {
                out.println(it.toString());
            }
            System.out.println();
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
