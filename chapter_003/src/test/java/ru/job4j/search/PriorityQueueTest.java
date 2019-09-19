package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("Mid", 3));
        queue.put(new Task("Up", 1));
        queue.put(new Task("Down", 4));
        Task result = queue.take();
        assertThat(result.getDesc(), is("Up"));
    }
}
