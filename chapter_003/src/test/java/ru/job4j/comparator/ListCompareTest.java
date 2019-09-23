package ru.job4j.comparator;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ListCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        ListCompare comparator = new ListCompare();
        int result = comparator.compare(
                "Ogurcov",
                "Ogurcov"
        );
        assertThat(result, is(0));
    }

    @Test
    public void whenLeftLessThenRightResultShouldBeNegative() {
        ListCompare comparator = new ListCompare();
        int result = comparator.compare(
                "Ogurcov",
                "Ogurcova"
        );
        assertThat(result, lessThan(0));
    }

    @Test
    public void whenLeftGreaterThenRightResultShouldBePositive() {
        ListCompare comparator = new ListCompare();
        int result = comparator.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenSecondCharOfLeftGreaterThanRightShouldBePositive() {
        ListCompare comparator = new ListCompare();
        int result = comparator.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result, greaterThan(0));
    }

    @Test
    public void whenThirdCharOfLeftLessThanRightShouldBeNegative() {
        ListCompare comparator = new ListCompare();
        int result = comparator.compare(
                "Pragrammer",
                "Programmer"
        );
        assertThat(result, lessThan(0));
    }
}
