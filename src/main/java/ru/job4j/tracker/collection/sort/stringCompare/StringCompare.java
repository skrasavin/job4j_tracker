package ru.job4j.tracker.collection.sort.stringCompare;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl;
        int index = 0;
        int i = left.length() < right.length() ? left.length() - 1: right.length() - 1;
        while (index != i) {
            rsl = Character.compare(left.charAt(index), right.charAt(index));
            if (rsl != 0) {
                return rsl;
            }
            index++;
        }

        return Integer.compare(left.length(), right.length());
    }
}