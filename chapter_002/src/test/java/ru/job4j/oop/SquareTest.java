package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        String ln = System.getProperty("line.separator");
        assertThat(square.draw(),
                    is(new StringBuilder()
                            .append("+++++++" + ln)
                            .append("+++++++" + ln)
                            .append("+++++++" + ln)
                            .append("+++++++" + ln)
                            .toString()
                    )
        );
    }
}
