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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                rsl[ind] = items[i];
                ind++;
            }
        }
        return Arrays.copyOf(rsl, ind);
    }


    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        }
        return false;
    }
    public boolean delete(int id) {
        if (indexOf(id) != -1) {
            items[indexOf(id)] = null;
            int start = id + 1;
            int length = size - id;
            items[size - 1] = null;
            System.arraycopy(items, start, items, id, length);
            size--;
            return true;
        }
        return false;
    }
}