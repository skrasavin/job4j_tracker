package ru.job4j.tracker.lambda.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FuncDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new FuncDiapason().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenSquareResults() {
        List<Double> result = new FuncDiapason().diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenPowResults() {
        List<Double> result = new FuncDiapason().diapason(5, 8, x -> Math.pow(x, 3));
        List<Double> expected = Arrays.asList(125D, 216D, 343D);
        assertThat(result, is(expected));
    }
}