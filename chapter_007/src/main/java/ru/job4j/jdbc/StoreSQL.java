package ru.job4j.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Storage for entries in database.
 * @author Viktor
 * @version 1.0
 */
public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    /**
     * Initialized storage.
     * @return true if connect not null, else false.
     */
    public boolean init() {
        config.init();
        try {
            connect = DriverManager.getConnection(config.get("url"));
            Statement statement = connect.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS entries(" +
                    "id serial primary key," +
                    "field integer)");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return connect != null;
    }

    /**
     * @return current connection.
     */
    public Connection getConnect() {
        return connect;
    }

    /**
     * Generated entries and write in database.
     * @param size numbers from 1 to size.
     */
    public void generate(int size) {
        try {
            PreparedStatement statement = connect.prepareStatement("INSERT INTO entries(field) VALUES(?)");
            for (int i = 1; i <= size; i++) {
                statement.setInt(1, i);
                statement.execute();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Load entry from database to ArrayList.
     * @return ArrayList with entry.
     */
    public List<XMLUsage.Entry> load() {
        List<XMLUsage.Entry> result = new ArrayList<>();
        try {
            Statement statement = connect.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM entries");
            while (set.next()) {
                XMLUsage.Entry entry = new XMLUsage.Entry(set.getInt("field"));
                result.add(entry);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
