package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public enum TrackerEnum {
    INSTANCE;

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }

    public static void main(String[] args) {
        Tracker tracker = INSTANCE.getTracker();
    }
}
