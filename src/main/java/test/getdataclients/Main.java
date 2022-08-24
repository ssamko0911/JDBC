package test.getdataclients;

import java.sql.*;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static String INSERT_NEW = "insert into clients(name, age, phone) values (?, ?, ?)";

    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        Driver.loadDriver();
        //Connector.connectToDB("jdbc:mysql://localhost:3306/testbase", "root", "root");
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carshop", "root", "root");
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from clients");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getNString("name");
                String phone = resultSet.getNString("phone");
                Client client = new Client(id, name, age, phone);
                clients.add(client);
            }

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

        for (Client element : clients) {
            System.out.println(element.getId() + " | " + element.getName() + " | " + element.getAge() + " | " + element.getPhone());
        }
        Connection connectionOne = null;
        //Statement statementOne = null;

        PreparedStatement preparedStatement = null;
        try {
            connectionOne = DriverManager.getConnection("jdbc:mysql://localhost:3306/carshop", "root", "root");
            preparedStatement = connectionOne.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, "Anton");
            preparedStatement.setInt(2, 33);
            preparedStatement.setString(3, "0677777777");

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}