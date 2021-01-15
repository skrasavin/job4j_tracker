package ru.job4j.tracker.collection.array2;

import java.util.ArrayList;
import java.util.List;

/**
 * ConvertMatrix2List
 */
public class ConvertMatrix2List {
    /**
     * toList
     * @param array test
     * @return test
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}