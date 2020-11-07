package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;

public class TrackerLazy {
    private static TrackerLazy instance;

    private TrackerLazy() {
    }

    public static TrackerLazy getInstance() {
        if (instance == null) {
            instance = new TrackerLazy();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
