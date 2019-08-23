package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckTest {
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true,true,true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true,true,true,false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    @Test
    public void whenDataNotMonoByFalseThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false,false,true,false};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

}
