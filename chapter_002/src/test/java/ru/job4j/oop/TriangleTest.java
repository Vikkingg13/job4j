package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        String ln = System.getProperty("line.separator");
        assertThat(triangle.draw(),
                is(new StringBuilder()
                .append("   +   " + ln)
                .append("  +++  " + ln)
                .append(" +++++ " + ln)
                .append("+++++++" + ln)
                .toString()
                )
        );
    }
}
