package ru.job4j.tracker.sigleton;
import ru.job4j.tracker.Item;

public enum TrackerEnum {
    INSTANCE;

    /* Конструкторы и методы. */
    public Item add(Item model) {
        return model;
    }

    public static void main(String[] args) {
        TrackerEnum tracker = TrackerEnum.INSTANCE;
    }
}
