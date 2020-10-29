package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("Erste");
        Item item2 = new Item("Zweite");
        Item item3 = new Item("Dritte");
        Item item4 = new Item("Erste");
        Tracker track = new Tracker();
        track.add(item);
        track.add(item2);
        track.add(item3);
        track.add(item4);
        Item[] itemTest = track.findAll();
        for (Item it : itemTest) {
            System.out.println(it.getName());
        }
        System.out.println();
        Item[] itemTest2 = track.findByName("Erste");
        for (Item it : itemTest2) {
            System.out.println(it.getName());
        }

        System.out.println();
        track.replace(3, item3);

        //System.out.println(item.getCreated().format(DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss")));
        //System.out.println(item.toString());

    }
}
