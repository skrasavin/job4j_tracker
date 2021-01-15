package ru.job4j.tracker.collection.sort.job;

import java.util.Comparator;

/**
 * SortByName
 */
public class SortByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
