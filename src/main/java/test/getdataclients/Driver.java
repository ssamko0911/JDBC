package test.getdataclients;

public class Driver {
    public static void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер jdbc загружен.");
        } catch (ClassNotFoundException e) {
            System.out.println("Дравер не загружен.");
            e.printStackTrace();
        }
    }
}