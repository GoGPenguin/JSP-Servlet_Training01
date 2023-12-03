package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static Connection cnn;
    static String url = "jdbc:mysql://localhost:3306/testltm21n10";
    static String user = "root";
    static String password = "";

    public static Connection getCnn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cnn;
    }
}
