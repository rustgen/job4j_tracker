package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FunctionRealizeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionRealize function = new FunctionRealize();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSqrtFunctionThenSqrtResults() {
        FunctionRealize function = new FunctionRealize();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(51D, 73D, 99D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenShowFunctionThenShowResults() {
        FunctionRealize function = new FunctionRealize();
        List<Double> result = function.diapason(5, 8, x -> 2 * Math.pow(3, x) + 1);
        List<Double> expected = Arrays.asList(487D, 1459D, 4375D);
        assertThat(result, is(expected));
    }

}