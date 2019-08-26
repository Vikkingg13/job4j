package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance1() {
        int x1 = 0;
        int y1 = 3;
        int x2 = 2;
        int y2 = 4;
        double expected = 2.2;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void distance2() {
        int x1 = 2;
        int y1 = 1;
        int x2 = 3;
        int y2 = 5;
        double expected = 4.1;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.1);
    }

    @Test
    public void distance3() {
        int x1 = 2;
        int y1 = 2;
        int x2 = 1;
        int y2 = 3;
        double expected = 1.4;
        double out = Point.distance(x1, y1, x2, y2);
        Assert.assertEquals(expected, out, 0.1);
    }
}
