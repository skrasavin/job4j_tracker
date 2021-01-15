package ru.job4j.tracker;

/**
 * UserAction
 */
public interface UserAction {
    String name();

    /**
     * execute
     * @param input test
     * @param tracker test
     * @return bool
     */
    boolean execute(Input input, Tracker tracker);
}
