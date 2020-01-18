package ru.job4j.jdbc;

import org.junit.Test;
import ru.job4j.tracker.*;
import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    @Test
    public void checkConnection() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            assertThat(tracker.init(), is(true));
        }
    }

    @Test
    public void whenAddItemThenDataBaseHasThisItem() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            assertThat(tracker.getAll().get(0).getName(), is("first"));
            assertThat(tracker.getAll().get(0).getDesc(), is("first description"));
            assertThat(tracker.getAll().get(0).getId(), is("1"));
        }
    }

    @Test
    public void whenReplaceItem() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            tracker.replace("1", new Item("second", "second description"));
            assertThat(tracker.getAll().get(0).getName(), is("second"));
            assertThat(tracker.getAll().get(0).getDesc(), is("second description"));
            assertThat(tracker.getAll().get(0).getId(), is("1"));
        }
    }

    @Test
    public void  whenDeleteItem() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            tracker.delete("1");
            assertThat(tracker.getAll().isEmpty(), is(true));
        }
    }

    @Test
    public void whenGetAll() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            tracker.add(new Item("second", "second description"));
            tracker.add(new Item("third", "third description"));
            ArrayList<Item> result = tracker.getAll();
            assertThat(result.get(0).getName(), is("first"));
            assertThat(result.get(1).getName(), is("second"));
            assertThat(result.get(2).getName(), is("third"));
            assertThat(result.size(), is(3));
        }
    }

    @Test
    public void whenFindByName() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            tracker.add(new Item("second", "second description"));
            ArrayList<Item> result = tracker.findByName("second");
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getName(), is("second"));
        }
    }

    @Test
    public void whenFindById() {
        try (TrackerSQL tracker = new TrackerSQL()) {
            tracker.init();
            tracker.add(new Item("first", "first description"));
            tracker.add(new Item("second", "second description"));
            tracker.add(new Item("third", "third description"));
            Item result = tracker.findById("3");
            assertThat(result.getName(), is("third"));
        }
    }
}
