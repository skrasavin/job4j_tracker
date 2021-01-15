package ru.job4j.tracker.lambda.lambda;

import java.util.function.Supplier;

/**
 * ScopeInside
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4};
        int total = 0;
        for (int num : number) {
            int scopeTotal = total;
            total = add(
                    () -> scopeTotal + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}