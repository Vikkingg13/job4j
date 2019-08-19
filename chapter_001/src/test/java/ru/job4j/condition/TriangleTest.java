package ru.job4j.condition;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
public class TriangleTest {

    @Test
    public void whenAreaSetThreePointsThenTriangleArea(){
        Triangle triangle = new Triangle();
        double result = triangle.area(0,0,3,0,2,2);
        double expected = 3D;
        assertThat(result,closeTo(expected,0.1));
    }

}
