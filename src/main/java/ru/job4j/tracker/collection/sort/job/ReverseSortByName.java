package ru.job4j.tracker.collection.sort.job;

import java.util.Comparator;

/**
 * ReverseSortByName
 */
public class ReverseSortByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
