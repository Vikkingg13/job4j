package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EndsWithTest {
    @Test
    public void whenStartWithPostfixThenTrue() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "llo");
        assertThat(result, is(true));
    }

    @Test
    public void whenStartWithPostfixThenTrue2() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "lo");
        assertThat(result, is(true));
    }

    @Test
    public void whenNotStartWithPostfixThenFalse() {
        EndsWith word = new EndsWith();
        boolean result = word.endsWith("Hello", "lla");
        assertThat(result, is(false));
    }
}
