package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] input = new int[]{3, 6, 1, 4};
        int[] result = turn.back(input);
        int[] expected = new int[]{4, 1, 6, 3};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] input = new int[]{3, 6, 1, 4, 9};
        int[] result = turn.back(input);
        int[] expected = new int[]{9, 4, 1, 6, 3};
        assertThat(result, is(expected));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray2() {
        Turn turn = new Turn();
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] result = turn.back(input);
        int[] expected = new int[]{5, 4, 3, 2, 1};
        assertThat(result, is(expected));
    }
}