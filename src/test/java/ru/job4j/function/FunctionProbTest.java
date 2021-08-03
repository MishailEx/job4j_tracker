package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FunctionProbTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionProb.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = FunctionProb.diapason(5, 8, x -> 2 * x * x + 1 * x + 1);
        List<Double> expected = Arrays.asList(56D, 79D, 106D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenIndicativeFunctionThenLinearResults() {
        List<Double> result = FunctionProb.diapason(5, 8, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(32D, 64D, 128D);
        assertThat(result, is(expected));
    }
}