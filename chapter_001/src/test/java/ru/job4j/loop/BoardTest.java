package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void when3x3(){
        Board board = new Board();
        String rsl = board.paint(3,3);
        String ln = System.lineSeparator();
        String expected = String.format("X X%s X %sX X%s", ln, ln, ln);
        assertThat(rsl,is(expected));
    }

    @Test
    public void when5x4(){
        Board board = new Board();
        String rsl = board.paint(5,4);
        String ln = System.lineSeparator();
        String expected = String.format("X X %s X X%sX X %s X X%sX X %s", ln, ln, ln, ln,ln);
        assertThat(rsl,is(expected));
    }
}
