package ru.job4j.loop;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeNumberTest {
    @Test
    public void whenFiveThenThree(){
        PrimeNumber primeNumber = new PrimeNumber();
        int rsl = primeNumber.calc(5);
        assertThat(rsl, is(3));
    }

    @Test
    public void whenTenThenFour(){
        PrimeNumber primeNumber = new PrimeNumber();
        int rsl = primeNumber.calc(10);
        assertThat(rsl, is(4));
    }

    @Test
    public void whenThreeThenTwo(){
        PrimeNumber primeNumber = new PrimeNumber();
        int rsl = primeNumber.calc(3);
        assertThat(rsl, is(2));
    }

    @Test
    public void whenTwentyThenEight(){
        PrimeNumber primeNumber = new PrimeNumber();
        int rsl = primeNumber.calc(20);
        assertThat(rsl, is(8));
    }
}
