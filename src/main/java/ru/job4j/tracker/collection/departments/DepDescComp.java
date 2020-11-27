package ru.job4j.tracker.collection.departments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] arrLeft = left.split("/");
        String[] arrRight = right.split("/");

        int rsl;
        rsl = arrRight[0].compareTo(arrLeft[0]);

        if (rsl != 0) {
            return rsl;
        }else {
            return arrLeft[arrLeft.length - 1].compareTo(arrRight[arrRight.length - 1]);
        }

    }
}