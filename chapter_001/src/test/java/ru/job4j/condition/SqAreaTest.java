package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class SqAreaTest {

    @Test
    public void square1() {
        int p = 8;
        int k = 3;
        int expected = 3;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void square2() {
        int p = 12;
        int k = 2;
        int expected = 8;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }

    @Test
    public void square3() {
        int p = 48;
        int k = 5;
        int expected = 80;
        int out = SqArea.square(p, k);
        Assert.assertEquals(expected, out);
    }
}
