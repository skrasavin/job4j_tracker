package ru.job4j.tracker.collection.departments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        String s = left.split("/", 3)[2];
        int i = 0;
        String s2 = right.split("/", 2)[1];
        ArrayList<String> arrays = new ArrayList<>();
//        arrays.add(left.split("/",));
        String s3 = s.split("K", 2)[1];
        String s4 = s.split("K", 2)[1];
        if (left.compareTo(right) < 0) {
            System.out.println("hello");
        }
        return left.compareTo(right);

    }
}