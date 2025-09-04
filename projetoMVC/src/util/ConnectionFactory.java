package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class ConnectionFactory {

    public static final String PATH = "jdbc:postgresql://localhost:5432//turmajava";
    public static String USER = "postgres";
    public static String PASSWORD = "postgres";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(PATH, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
            //throw new Exception(e.getMessage());
        }

    }

    public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt) throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (rs != null) {
                stmt.close();
            }
            if (rs != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
