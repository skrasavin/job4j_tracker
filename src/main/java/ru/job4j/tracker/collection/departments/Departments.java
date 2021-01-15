package ru.job4j.tracker.collection.departments;

import java.util.*;

/**
 * Departments
 */
public class Departments {

    /**
     * fillGaps
     * @param deps test
     * @return test
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();

        for (String value : deps) {
            StringBuilder start = new StringBuilder();
            for (String el : value.split("/")) {
                if (!start.toString().equals("")) {
                    start.append("/").append(el);
                    tmp.add(start.toString());
                } else {
                    tmp.add(el);
                    start = new StringBuilder(el);
                }
            }
        }
        System.out.println(tmp);
        return new ArrayList<>(tmp);
    }

    /**
     * sortAsc
     * @param args test
     */
    public static void sortAsc(List<String> args) {
        Collections.sort(args);
    }

    /**
     * SortDesc
     * @param args test
     */
    public static void sortDesc(List<String> args) {
        args.sort(new DepDescComp());
    }
}