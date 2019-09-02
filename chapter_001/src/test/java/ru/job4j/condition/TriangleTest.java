package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Triangle triangle = new Triangle();
        Point first = new Point(0, 0);
        Point second = new Point(3, 0);
        Point third = new Point(2, 2);
        double result = triangle.area(first, second, third);
        double expected = 3D;
        assertThat(result, closeTo(expected, 0.1));
    }

}
