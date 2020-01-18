package ru.job4j.jdbc;

import ru.job4j.tracker.ITracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Adding, replacing, deleting and finding items in the database.
 * @author Viktor Grigoriev
 * @version 1.0
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private Connection connection;

    /**
     * Create connection with DBMS and create table items.
     * @return true, if connection success, else false.
     */
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.execute("DROP TABLE IF EXISTS items");
            st.execute("CREATE TABLE IF NOT EXISTS items(" +
                            "id serial primary key," +
                            "name varchar(200)," +
                            "description text)"
            );
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return this.connection != null;
    }

    /**
     * Adding item to the database.
     * @param  item added
     * @return adding item with id.
     */
    @Override
    public Item add(Item item) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO items (name, description) values(?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.executeUpdate();
            ResultSet generatedKey = statement.getGeneratedKeys();
            if (generatedKey.next()) {
                item.setId(generatedKey.getString(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }

    /**
     * Replace item by id.
     * @param item replaced
     * @return true, if item has been replaced, else false.
     */
    @Override
    public boolean replace(String id, Item item) {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE items SET name=?, description=? WHERE id=?");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setInt(3, Integer.parseInt(id));
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result > 0;
    }

    /**
     * Delete item by id.
     * @param id item to delete.
     * @return true if item has been delete from the database, else false.
     */
    @Override
    public boolean delete(String id) {
        int result = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id=?");
            statement.setInt(1, Integer.parseInt(id));
            result = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result > 0;
    }

    /**
     * Return all items from the database.
     * @return ArrayList all items from the database.
     */
    @Override
    public ArrayList<Item> getAll() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Item item = new Item(set.getString("name"), set.getString("description"));
                item.setId(set.getString("id"));
                result.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Find items by name.
     * @param name items.
     * @return ArrayList items from the database.
     */
    @Override
    public ArrayList<Item> findByName(String name) {
        ArrayList<Item> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name=?");
            statement.setString(1, name);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Item item = new Item(set.getString("name"), set.getString("description"));
                item.setId(set.getString("id"));
                result.add(item);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Find item by id.
     * @param id item.
     * @return found ttem.
     */
    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT *  FROM items WHERE id=?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                item = new Item(set.getString("name"), set.getString("description"));
                item.setId(set.getString("id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return item;
    }

    @Override
    public void close() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
