package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private String ln = System.getProperty("line.separator");
    private final String menu = String.format("\nМеню.%s0. Добавить заявку.%s1. Показать все заявки.%s2. Редактировать заявку.%s3. Удалить заявку.%s4. Искать по ID.%s5. Искать по имени.%s6. Выйти.%s",
            ln, ln, ln, ln, ln, ln, ln, ln);
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input stub = new StubInput(new String[] {"0", "test1", "This just test", "y"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.getAll().get(0).getName(), is("test1"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"2", item.getId(), "replace item", "replace desc", "y"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("replace item"));
    }

    @Test
    public void whenDeleteByValidIdThenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"3", item.getId(), "y"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()), is((Item) null));
    }

    @Test
    public void whenDeleteByInvalidIdThenNotDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input stub = new StubInput(new String[] {"3", "11111111", "y"});
        new StartUI(stub, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is(item.getName()));
    }

    @Test
    public void whenUserEnterZeroThenPrintMessage() {
        Tracker tracker = new Tracker();
        Input stub = new StubInput(new String[] {"0", "test name", "test disc", "y"});
        new StartUI(stub, tracker).init();
        String id = tracker.getAll().get(0).getId();
        String result = this.out.toString();
        String expected = String.format(menu + "---------Добавление новой заявки---------%s---------Новая заявка с getid : " + id + " ---------%s", ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterOneThenPrintMessage() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        Input stub = new StubInput(new String[] {"1", "y"});
        new StartUI(stub, tracker).init();
        String id = item.getId();
        String result = this.out.toString();
        String expected = String.format(menu + "---------Заявки---------%sИмя: test name Описание: test desc ID:" + id + "%s", ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterTwoThenPrintMessage() {
        Tracker tracker = new Tracker();
        Item old = tracker.add(new Item("old name", "old desc"));
        String id = old.getId();
        Input stub = new StubInput(new String[] {"2", id, "new name", "new desc", "y"});
        new StartUI(stub, tracker).init();
        String result = this.out.toString();
        String expected = String.format(menu + "---------Заявка с getid : " + id + " успешно отредактирована---------%s", ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterThreeThenPrintMessage() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        String id = item.getId();
        Input stub = new StubInput(new String[] {"3", id, "y"});
        new StartUI(stub, tracker).init();
        String result = this.out.toString();
        String expected = String.format(menu + "---------Заявка с getid : " + id + " успешно удалена---------%s", ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterFourThenPrintMessage() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        String id = item.getId();
        Input stub = new StubInput(new String[] {"4", id, "y"});
        new StartUI(stub, tracker).init();
        String result = this.out.toString();
        String expected = String.format(menu + "Имя: " + item.getName() + " Описание: " + item.getDesc() + " ID:" + item.getId() + "%s", ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterFiveThenPrintMessage() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("test name", "test1 desc"));
        Item second = tracker.add(new Item("test name", "test2 desc"));
        Input stub = new StubInput(new String[] {"5", "test name", "y"});
        new StartUI(stub, tracker).init();
        String result = this.out.toString();
        String expected = String.format(menu + "Имя: " + first.getName() + " Описание: " + first.getDesc() + " ID:" + first.getId() + "%s"
                +
                "Имя: " + second.getName() + " Описание: " + second.getDesc() + " ID:" + second.getId() + "%s", ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenUserEnterSixThenPrintMessage() {
        Tracker tracker = new Tracker();
        Input stub = new StubInput(new String[] {"6"});
        new StartUI(stub, tracker).init();
        String result = this.out.toString();
        String expected = String.format(menu + "---------Выход---------%s", ln);
        assertThat(result, is(expected));
    }
}