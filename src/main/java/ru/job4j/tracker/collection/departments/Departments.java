package ru.job4j.tracker.collection.departments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}