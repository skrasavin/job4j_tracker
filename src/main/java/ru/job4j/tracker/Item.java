package ru.job4j.tracker;

import java.time.LocalDateTime;

/**
 * Item
 */
public class Item implements Comparable<Item> {
    private LocalDateTime created = LocalDateTime.now();
    private int id;
    private String name;

    /**
     * Item
     */
    public Item() {
    }

    /**
     * Item
     * @param id test
     */
    public Item(int id) {
        this.id = id;
    }

    /**
     * Item
     * @param name test
     */
    public Item(String  name) {
        this.name = name;
    }

    /**
     * Item
     * @param id test
     * @param name test
     */
    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * LocalDateTime
     * @return date
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * getId
     * @return test
     */
    public int getId() {
        return id;
    }

    /**
     * setId
     * @param id test
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getName
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * SetName
     * @param name test
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(id, o.id);
    }

    @Override
    public String toString() {
        return  "id=" + id
                + ", name=" + name;
    }
}
/*
    @Override
    public String toString() {
        return  "id=" + id +
                ", name=" + name +
                ", created='" + created;
    }
 */