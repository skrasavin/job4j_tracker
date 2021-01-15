package ru.job4j.tracker.collection;

import java.util.HashSet;

/**
 * UsageHashSet
 */
public class UsageHashSet {

    /**
     * toArray
     * @param args test
     */
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<>();
        autos.add("Lada");
        autos.add("BMW");
        autos.add("Volvo");
        autos.add("Toyota");

        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
