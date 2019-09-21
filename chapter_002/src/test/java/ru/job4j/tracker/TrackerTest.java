package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenDeleteItemThenNewArray() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        tracker.add(first);
        tracker.add(second);
        tracker.delete(first.getId());
        List<Item> result = tracker.getAll();
        List<Item> expected = new ArrayList<>();
        expected.add(second);
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenAddTwoItemsThenGetAllReturnArrayWithTwoItems() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        tracker.add(first);
        tracker.add(second);
        List<Item> result = tracker.getAll();
        List<Item> expected = new ArrayList<>();
        expected.add(first);
        expected.add(second);
        assertThat(result, is(expected));

    }
    @Test
    public void whenArrayHasItemThenFindByNameReturnThisItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("test1");
        Item second = new Item("test2");
        Item third = new Item("test1");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = tracker.findByName(first.getName());
        List<Item> expected = new ArrayList<>();
        expected.add(first);
        expected.add(third);
        assertThat(result, is(expected));
    }

    @Test
    public void whenArrayHasItemThenFindByIdReturnThisItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result, is(item));
    }

    @Test
    public void whenArrayNotHaveItemThenFindByIdReturnNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        Item result = tracker.findById(item.getId());
        assertThat(result, is((Item) null));
    }
}
