package ru.job4j.condition;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class PointTest {
    @Test
    public void whenZeroAndTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10D));
    }

    @Test
    public void whenCheckItSelf() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }

    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 2);
        first.info();
        Point second = new Point(4, 3);
        second.info();
    }

    @Test
    public void when072And0106ThenTen() {
        Point first = new Point(0, 7, 2);
        Point second = new Point(0, 10, 6);
        double result = first.distance3d(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(5D));
    }

    @Test
    public void when052And056ThenTen() {
        Point first = new Point(0, 5, 2);
        Point second = new Point(0, 5, 6);
        double result = first.distance3d(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(4D));
    }
}
