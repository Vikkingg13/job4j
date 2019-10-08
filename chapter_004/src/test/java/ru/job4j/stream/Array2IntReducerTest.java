package ru.job4j.stream;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class Array2IntReducerTest {
    @Test
    public void whenArrayIntegerReduceThenInt() {
        Array2IntReducer reducer = new Array2IntReducer();
        int result = reducer.convert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertThat(result, is(120));
    }

    @Test
    public void whenArrayEmptyThenZero() {
        Array2IntReducer reducer = new Array2IntReducer();
        int result = reducer.convert(new int[]{});
        assertThat(result, is(0));
    }
}
