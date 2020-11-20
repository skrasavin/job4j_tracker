package ru.job4j.tracker.collection.sort.lexsort;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftVal = Integer.parseInt(left.split("\\.", 2)[0]);
        int rightVal = Integer.parseInt(right.split("\\.", 2)[0]);
        return Integer.compare(leftVal, rightVal);
    }
}