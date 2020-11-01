package ru.job4j.tracker;

public class ShowAllAction implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item it : items) {
            System.out.println(it.getId() + "." + it.getName());
        }
        return true;
    }
}
