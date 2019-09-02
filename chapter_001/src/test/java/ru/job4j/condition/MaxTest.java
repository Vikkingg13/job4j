package ru.job4j.condition;
import org.junit.Test;
import static  org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        Max test = new Max();
        int result = test.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenMax3To1Then3() {
        Max test = new Max();
        int result = test.max(3, 1);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax5To5Then5() {
        Max test = new Max();
        int result = test.max(5, 5);
        assertThat(result, is(5));
    }

    @Test
    public void whenMaxWithThreeArgs241Then4() {
        Max test = new Max();
        int result = test.max(2, 4, 1);
        assertThat(result, is(4));
    }

    @Test
    public void whenMaxWithFourArgs5634Then6() {
        Max test = new Max();
        int result = test.max(5, 6, 3, 4);
        assertThat(result, is(6));
    }

}
