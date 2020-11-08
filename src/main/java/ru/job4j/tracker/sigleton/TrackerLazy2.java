package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Tracker;

public class TrackerLazy2 {
    private void Tracker() {
    }

    public static Tracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerLazy2.getInstance();
        Tracker tracker1 = TrackerLazy2.getInstance();
        System.out.println(tracker);
        System.out.println(tracker1);
    }
}
