package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

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
