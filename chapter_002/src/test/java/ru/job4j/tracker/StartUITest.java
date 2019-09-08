package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input stub = new StubInput(new String[] {"0", "test1", "This just test", "6"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.getAll()[0].getName(), is("test1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"2", item.getId(), "replace item", "replace desc", "6" });
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replace item"));
    }

    @Test
    public void whenDeleteByValidIdThenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"3", item.getId(), "6"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()), is((Item) null));
    }

    @Test
    public void whenDeleteByInvalidIdThenNotDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"3", "11111111", "6"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }
}
