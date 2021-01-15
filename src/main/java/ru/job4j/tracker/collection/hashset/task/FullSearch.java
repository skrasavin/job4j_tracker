package ru.job4j.tracker.collection.hashset.task;

import java.util.HashSet;
import java.util.List;

/**
 * FullSearch
 */
public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task element : list) {
            numbers.add(element.getNumber());
        }
        return numbers;
    }
}