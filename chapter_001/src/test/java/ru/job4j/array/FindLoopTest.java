package ru.job4j.array;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas1Then2() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 8, 1};
        int value = 1;
        int result = findLoop.indexOf(input, value);
        assertThat(result, is(2));
    }

    @Test
    public void whenArrayHas3Then0() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 8, 1};
        int value = 3;
        int result = findLoop.indexOf(input, value);
        assertThat(result, is(0));
    }

    @Test
    public void whenArrayNo5ThenMinus1() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 8, 1};
        int value = 5;
        int result = findLoop.indexOf(input, value);
        assertThat(result, is(-1));
    }

    @Test
    public void whenFind5Then4() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 8, 1, 6, 5, 2};
        int value = 5;
        int start = 1;
        int finish = 4;
        int result = findLoop.indexOf(input, value, start, finish);
        assertThat(result, is(4));
    }

    @Test
    public void whenFind3ThenMinus1() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 8, 1, 6, 5, 2};
        int value = 3;
        int start = 1;
        int finish = 4;
        int result = findLoop.indexOf(input, value, start, finish);
        assertThat(result, is(-1));
    }
    @Test
    public void whenSortBubble3() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 1, 2};
        int[] result = findLoop.sortBubble(input);
        int[] expected = new int[] {1, 2, 3};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortBubble5() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{8, 2, 5, 4, 1};
        int[] result = findLoop.sortBubble(input);
        int[] expected = new int[] {1, 2, 4, 5, 8};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortSelection3() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{5, 4, 1};
        int[] result = findLoop.sortSelection(input);
        int[] expected = new int[] {1, 4, 5};
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortSelection5() {
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3, 1, 2, 7, 5};
        int[] result = findLoop.sortSelection(input);
        int[] expected = new int[] {1, 2, 3, 5, 7};
        assertThat(result, is(expected));
    }
}
