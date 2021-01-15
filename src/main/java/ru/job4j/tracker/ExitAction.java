package ru.job4j.tracker;

/**
 * Exit
 */
public class ExitAction implements UserAction {
    private final Output out;

    /**
     * ExitAction
     * @param out test
     */
    public ExitAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Exit";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
