package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest {
    @Test
    public void whenArrayHas1Then2(){
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3,8,1};
        int value = 1;
        int result = findLoop.indexOf(input,value);
        assertThat(result, is(2));
    }

    @Test
    public void whenArrayHas3Then0(){
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3,8,1};
        int value = 3;
        int result = findLoop.indexOf(input,value);
        assertThat(result, is(0));
    }

    @Test
    public void whenArrayNo5ThenMinus1(){
        FindLoop findLoop = new FindLoop();
        int[] input = new int[]{3,8,1};
        int value = 5;
        int result = findLoop.indexOf(input,value);
        assertThat(result, is(-1));
    }
}
