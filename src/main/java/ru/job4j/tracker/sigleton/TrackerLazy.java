package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import javax.sound.midi.Track;

public class TrackerLazy {
    private static Tracker instance;

    private TrackerLazy() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = getInstance();
        Tracker tracker1 = getInstance();
        System.out.println(tracker);
        System.out.println(tracker1);
    }
}
