package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    private final Output out;

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
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item it : items) {
                System.out.println(it.toString());
            }
            System.out.println();
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
