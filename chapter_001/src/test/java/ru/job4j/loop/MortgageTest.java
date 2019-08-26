package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MortgageTest {
    @Test
    public void when1Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(1000, 100, 10);
        assertThat(year, is(1));
    }

    @Test
    public void when2Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(100, 10, 50);
        assertThat(year, is(2));
    }

    @Test
    public void when10Year() {
        Mortgage mortgage = new Mortgage();
        int year = mortgage.year(5000, 60, 35);
        assertThat(year, is(10));
    }

}
