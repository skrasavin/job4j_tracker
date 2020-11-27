package ru.job4j.tracker.collection.departments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");
        int index = 0;
        int rsl;
        rsl = arrRight[index].compareTo(arrLeft[index]);
        if (rsl != 0) {
            return arrLeft[index].compareTo(arrRight[index]);
        }
        return rsl;
    }
}