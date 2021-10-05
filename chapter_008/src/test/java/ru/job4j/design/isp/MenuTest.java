package ru.job4j.design.isp;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    final private String ln = System.lineSeparator();

    @Test
    public void testOutputMenuWithRenameOperation() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        System.setOut(out);
        ByteArrayInputStream stub = new ByteArrayInputStream(
                "1.1\n1\nNew Title\nYes".getBytes()
        );
        Task st1 = new Task("Sub Task One");
        Task st3 = new Task("Sub Task Three");
        Task st2 = new Task("Sub Task Two", Arrays.asList(st1, st3));
        Task t1 = new Task("Task One", Arrays.asList(st2));
        Menu menu = new Menu(Arrays.asList(t1));
        menu.setInput(stub);
        menu.run();
        String string =
                "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Select task:"
                        + ln + "Enter command:"
                        + ln + "0 - next"
                        + ln + "1 - rename current task"
                        + ln + "2 - add sub task"
                        + ln + "3 - delete sub task"
                        + ln + "Enter title: "
                        + ln + "Task One 1"
                        + ln + "----New Title 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Exit? Yes/No"
                        + ln;
        assertEquals(string, bytes.toString());
    }

    @Test
    public void testOutputMenuWithAddOperation() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        System.setOut(out);
        ByteArrayInputStream stub = new ByteArrayInputStream(
                "1\n2\nNew Title\nYes".getBytes()
        );
        Task st1 = new Task("Sub Task One");
        Task st3 = new Task("Sub Task Three");
        Task st2 = new Task("Sub Task Two", Arrays.asList(st1, st3));
        Task t1 = new Task("Task One", Arrays.asList(st2));
        Menu menu = new Menu(Arrays.asList(t1));
        menu.setInput(stub);
        menu.run();
        String string =
                "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Select task:"
                        + ln + "Enter command:"
                        + ln + "0 - next"
                        + ln + "1 - rename current task"
                        + ln + "2 - add sub task"
                        + ln + "3 - delete sub task"
                        + ln + "Enter title for new task: "
                        + ln + "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "----New Title 1.2"
                        + ln + "Exit? Yes/No"
                        + ln;
        assertEquals(string, bytes.toString());
    }

    @Test
    public void testOutputMenuWithDeleteOperation() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        System.setOut(out);
        ByteArrayInputStream stub = new ByteArrayInputStream(
                "1\n3\n1\nYes".getBytes()
        );
        Task st1 = new Task("Sub Task One");
        Task st3 = new Task("Sub Task Three");
        Task st2 = new Task("Sub Task Two", Arrays.asList(st1, st3));
        Task t1 = new Task("Task One", Arrays.asList(st2));
        Menu menu = new Menu(Arrays.asList(t1));
        menu.setInput(stub);
        menu.run();
        String string =
                "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Select task:"
                        + ln + "Enter command:"
                        + ln + "0 - next"
                        + ln + "1 - rename current task"
                        + ln + "2 - add sub task"
                        + ln + "3 - delete sub task"
                        + ln + "Enter index task for delete: "
                        + ln + "Task One 1"
                        + ln + "Exit? Yes/No"
                        + ln;
        assertEquals(string, bytes.toString());
    }

    @Test
    public void testOutputMenuWithNextOperation() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(bytes);
        System.setOut(out);
        ByteArrayInputStream stub = new ByteArrayInputStream(
                "1\n4\nYes".getBytes()
        );
        Task st1 = new Task("Sub Task One");
        Task st3 = new Task("Sub Task Three");
        Task st2 = new Task("Sub Task Two", Arrays.asList(st1, st3));
        Task t1 = new Task("Task One", Arrays.asList(st2));
        Menu menu = new Menu(Arrays.asList(t1));
        menu.setInput(stub);
        menu.run();
        String string =
                "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Select task:"
                        + ln + "Enter command:"
                        + ln + "0 - next"
                        + ln + "1 - rename current task"
                        + ln + "2 - add sub task"
                        + ln + "3 - delete sub task"
                        + ln + "Task One 1"
                        + ln + "----Sub Task Two 1.1"
                        + ln + "--------Sub Task One 1.1.1"
                        + ln + "--------Sub Task Three 1.1.2"
                        + ln + "Exit? Yes/No"
                        + ln;
        assertEquals(string, bytes.toString());
    }
}
