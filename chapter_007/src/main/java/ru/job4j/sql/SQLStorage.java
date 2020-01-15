package ru.job4j.sql;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.sql.*;

public class SQLStorage {
    private static final Logger Log = LogManager.getLogger(SQLStorage.class.getName());

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/java_a_from_z";
        String username = "postgres";
        String password = "password";
        Connection conn =  null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            PreparedStatement st = conn.prepareStatement("delete from author where id=2");
            st.executeUpdate();
            st.close();
        } catch (SQLException ex) {
            Log.error(ex.getMessage(), ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Log.error(ex.getMessage(), ex);
                }
            }
        }
    }
}
