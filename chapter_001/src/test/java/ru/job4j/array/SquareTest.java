package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenBound3Then149(){
        Square square = new Square();
        int[] result = square.calculate(3);
        int[] expected = new int[]{1,4,9};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBound5Then1_4_9_16_25(){
        Square square = new Square();
        int[] result = square.calculate(5);
        int[] expected = new int[]{1,4,9,16,25};
        assertThat(result, is(expected));
    }

    @Test
    public void whenBound7Then1_4_9_16_25_36_49(){
        Square square = new Square();
        int[] result = square.calculate(7);
        int[] expected = new int[]{1,4,9,16,25,36,49};
        assertThat(result, is(expected));
    }
}

