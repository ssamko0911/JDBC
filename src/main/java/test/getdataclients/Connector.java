package test.getdataclients;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection connectToDB(String someURL, String someLogin, String somePwd) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(someURL, someLogin, somePwd);
            if (!connection.isClosed()) {
                System.out.println("Подключение к БД успешно.");
            }
            if (connection.isClosed()) {
                System.out.println("Подключение к БД остановлено.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Подключение к БД не успешно.");
        }
        return connection;
    }
}
