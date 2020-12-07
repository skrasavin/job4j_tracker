package ru.job4j.tracker.lambda.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3, 4};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
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