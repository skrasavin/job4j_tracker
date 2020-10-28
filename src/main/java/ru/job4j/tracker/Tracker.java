package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }
    public Item[] findAll() {
        int ind = 0;
        for (Item item : items) {
            if (item != null) {
                ind++;
            }
        }
        return Arrays.copyOf(items, ind);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int ind = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                rsl[ind] = item;
                ind++;
            }
        }
        return Arrays.copyOf(rsl, ind);
    }


    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}