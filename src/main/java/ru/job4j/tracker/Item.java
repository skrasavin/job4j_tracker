package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    @Override
    public String toString() {
        return "Item{" +
                "created=" + created +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Item() {

    }

    public Item(int id) {
        this.id = id;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return this.created;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
