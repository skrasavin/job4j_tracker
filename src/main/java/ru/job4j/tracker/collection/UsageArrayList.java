package ru.job4j.tracker.collection;

import java.util.ArrayList;

/**
 * UsageArrayList
 */
public class UsageArrayList {

    /**
     * main
     * @param args test
     */
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Petr");
        names.add("Ivan");
        names.add("Stepan");

        for (String name : names) {
            System.out.println(name);
        }
    }
}
