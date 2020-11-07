package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;

public class TrackerLazy2 {
    private TrackerLazy2() {
    }

    public static TrackerLazy2 getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }

    private static final class Holder {
        private static final TrackerLazy2 INSTANCE = new TrackerLazy2();
    }

    public static void main(String[] args) {
        TrackerLazy2 tracker = TrackerLazy2.getInstance();
    }
}
