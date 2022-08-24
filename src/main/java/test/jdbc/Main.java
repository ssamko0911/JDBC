package test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/carshop";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is registered!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;

        try{
            connection =DriverManager.getConnection(URL, LOGIN, PASSWORD);
            if (!connection.isClosed()){
                System.out.println("Succesfull connection to the DB!");
            }

            //connection.close();
            if (connection.isClosed()) {
                System.out.println("Connection is closed.");
            }

            statement = connection.createStatement();
            //statement.execute("INSERT into cars (mark_id, model, price) values (2, '911 Turbo S',290000)");

            statement.addBatch("INSERT into cars (mark_id, model, price) values (4, '500',78000)");
            statement.addBatch("INSERT into cars (mark_id, model, price) values (4, 'Tipo',100000)");
            statement.addBatch("INSERT into cars (mark_id, model, price) values (3, '360 Spider',700000)");
            statement.executeBatch();

            boolean closed = statement.isClosed();
            System.out.println(closed);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}