package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerStaticFinalTest {
    @Test
    public void whenTrackerStaticFinalIsSingleton() {
        TrackerStaticFinal first = TrackerStaticFinal.getInstance();
        TrackerStaticFinal second = TrackerStaticFinal.getInstance();
        second.add(new Item("name from second", "desc"));
        assertThat(first.getAll().get(0).getName(), is("name from second"));
    }

}
