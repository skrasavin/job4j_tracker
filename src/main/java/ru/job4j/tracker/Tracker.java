package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

public class Tracker {
    private final ArrayList<Item> items = new ArrayList<>();
    int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return items;
    }

        public ArrayList<Item> findByName(String key) {
            ArrayList<Item> rsl = new ArrayList<>();
            for (int i = 0; i <= size; i++) {
                if (items.get(i) != null && items.get(i).getName().equals(key)) {
                    rsl.add(items.get(i));
                }
            }
            return rsl;
        }


    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index <= size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            return true;
        }
        return false;
    }
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, null);
            //int start = id + 1;
            //int length = size - id;
            //System.arraycopy(items, id, items, index, length);
            //size--;
            return true;
        }
        return false;
    }
}