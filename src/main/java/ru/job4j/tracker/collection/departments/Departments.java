package ru.job4j.tracker.collection.departments;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();

        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (!start.equals("")) {
                    tmp.add(start += "/" + el);
                }else {
                    tmp.add(el);
                    start = el;
                }
            }
        }
        System.out.println(tmp);
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> args) {
        Collections.sort(args);
    }

    public static void sortDesc(List<String> args) {
        Collections.sort(args, new DepDescComp());
    }
}