package ru.job4j.jdbc;

import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = TrackerSQLTest.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception ex) {
            throw new IllegalStateException();
        }
    }

    @Test
    public void whenAddItemThenDataBaseHasThisItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(init()))) {
            Item item = tracker.add(new Item("first", "first description"));
            assertThat(tracker.getAll().get(0).getName(), is("first"));
            assertThat(tracker.getAll().get(0).getDesc(), is("first description"));
            assertThat(tracker.getAll().get(0).getId(), is(item.getId()));
        }
    }

    @Test
    public void whenReplaceItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item item = tracker.add(new Item("first", "first description"));
            tracker.replace(item.getId(), new Item("second", "second description"));
            assertThat(tracker.getAll().get(0).getName(), is("second"));
            assertThat(tracker.getAll().get(0).getDesc(), is("second description"));
            assertThat(tracker.getAll().get(0).getId(), is(item.getId()));
        }
    }

    @Test
    public void  whenDeleteItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(init()))) {
            Item item = tracker.add(new Item("first", "first description"));
            tracker.delete(item.getId());
            assertThat(tracker.getAll().isEmpty(), is(true));
        }
    }

    @Test
    public void whenGetAll() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(init()))) {
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
    public void whenFindByName() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(init()))) {
            Item first = tracker.add(new Item("first", "first description"));
            Item second = tracker.add(new Item("second", "second description"));
            ArrayList<Item> result = tracker.findByName("second");
            assertThat(result.size(), is(1));
            assertThat(result.get(0).getName(), is("second"));
        }
    }

    @Test
    public void whenFindById() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item first = tracker.add(new Item("first", "first description"));
            Item second = tracker.add(new Item("second", "second description"));
            Item third = tracker.add(new Item("third", "third description"));
            Item result = tracker.findById(third.getId());
            assertThat(result.getName(), is("third"));
        }
    }
}
