package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class FuncDiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResult() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(3, 6, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(7D, 9D, 11D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResult() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(3, 6, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(10D, 17D, 26D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResult() {
        FuncDiapason function = new FuncDiapason();
        List<Double> result = function.diapason(3, 6, Math::log);
        List<Double> expected = Arrays.asList(1.0986122886681098, 1.3862943611198906, 1.6094379124341003);
        assertThat(result, is(expected));
    }
}
