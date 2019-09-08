package ru.job4j.tracker;

import org.junit.Test;
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
        Item[] result = tracker.getAll();
        Item[] expected = new Item[] {second};
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
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
        Item[] result = tracker.getAll();
        Item[] expected = new Item[] {first, second};
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
        Item[] result = tracker.findByName(first.getName());
        assertThat(result, is(new Item[] {first, third}));
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
