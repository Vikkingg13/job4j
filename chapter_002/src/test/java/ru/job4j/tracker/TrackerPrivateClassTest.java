package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerPrivateClassTest {
    @Test
    public void whenTrackerPrivateClassIsSingleton() {
        TrackerPrivateClass first = TrackerPrivateClass.getInstance();
        first.add(new Item("test1", "desc1"));
        TrackerPrivateClass second = TrackerPrivateClass.getInstance();
        TrackerPrivateClass third = TrackerPrivateClass.getInstance();
        assertThat(third.getAll()[0].getDesc(), is("desc1"));
    }
}
