package ru.job4j.list;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleStackTest {
    @Test
    public void whenPushElementsFiveTenFifteenThenPollFifteenTenFive() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(5);
        stack.push(10);
        stack.push(15);
        assertThat(stack.poll(), is(15));
        assertThat(stack.poll(), is(10));
        assertThat(stack.poll(), is(5));
    }
}
