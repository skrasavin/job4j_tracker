package ru.job4j.tracker.lambda.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FuncDiapason {

    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rsl = new ArrayList<>();
        for (; start < end; start++) {
            rsl.add(func.apply((double) start));
        }
        return rsl;
    }
}
