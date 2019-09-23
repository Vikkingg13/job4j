package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerStaticTest {
    @Test
    public void whenTrackerStaticIsSingleton() {
        TrackerStatic first = TrackerStatic.getInstance();
        TrackerStatic second = TrackerStatic.getInstance();
        second.add(new Item("test1", "desc from second"));
        assertThat(first.getAll().get(0).getDesc(), is("desc from second"));

    }
}
