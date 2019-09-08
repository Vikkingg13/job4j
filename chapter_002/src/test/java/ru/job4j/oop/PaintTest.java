package ru.job4j.oop;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenDrawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        String ln = System.getProperty("line.separator");
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("+++++++" + ln)
                        .append("+++++++" + ln)
                        .append("+++++++" + ln)
                        .append("+++++++" + ln + ln)
                        .toString()
                )
        );
        System.setOut(stdout);
    }

    @Test
    public void whenDrawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        String ln = System.getProperty("line.separator");
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("   +   " + ln)
                        .append("  +++  " + ln)
                        .append(" +++++ " + ln)
                        .append("+++++++" + ln + ln)
                        .toString()
                )
        );
        System.setOut(stdout);
    }
}
