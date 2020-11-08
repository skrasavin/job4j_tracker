package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TrackerEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerEager.getInstance();
    }
}
