package ru.job4j.tracker.collection.array;

import java.util.List;

/**
 * TrackerEnum
 */
public class ConvertList2Array {

    /**
     * toArray
     * @param list test
     * @param cells test
     * @return test
     */
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (Integer num : list) {
            if (cell > cells - 1) {
                cell = 0;
                array[++row][cell++] = num;
            } else {
                array[row][cell] = num;
                cell++;
            }

        }
        return array;
    }

    /**
     * main
     * @param args test
     */
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}