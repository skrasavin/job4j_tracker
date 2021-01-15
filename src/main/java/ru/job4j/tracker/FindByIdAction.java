package ru.job4j.tracker;

import java.util.Objects;

/**
 * FindByIdAction
 */
public class FindByIdAction implements UserAction {
    private final Output out;

    /**
     * FindByIdAction
     * @param out test
     */
    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("==== Find item by id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElse(item, "Заявка с таким id не найдена"));
        return true;
    }
}
