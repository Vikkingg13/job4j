package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static  org.junit.Assert.assertThat;

public class CounterTest {

    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty(){
        Counter count = new Counter();
        int result = count.add(0,10);
        assertThat(result, is(30));
    }

    @Test
    public void whenSumEvenNumbersFromOneToSevenThenTwelve(){
        Counter count = new Counter();
        int result = count.add(0,7);
        assertThat(result, is(12));
    }

    @Test
    public void whenSumEvenNumbersFromSixToTenThenTwentyFour(){
        Counter count = new Counter();
        int result = count.add(6,10);
        assertThat(result, is(24));
    }

    @Test
    public void whenSumEvenNumbersFromTenToOneThenZero(){
        Counter count = new Counter();
        int result = count.add(10,0);
        assertThat(result, is(0));
    }

}
