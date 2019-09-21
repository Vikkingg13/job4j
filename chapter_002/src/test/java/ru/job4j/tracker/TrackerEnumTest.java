package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerEnumTest {
    @Test
    public void whenTrackerEnumIsSingleton() {
        TrackerEnum first = TrackerEnum.INSTANCE;
        first.add(new Item("item from first", "desc"));
        TrackerEnum second = TrackerEnum.INSTANCE;
        assertThat(second.getAll().get(0).getName(), is("item from first"));
    }
}
