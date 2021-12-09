package SQLDetails;

public class Details {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Jee@291976@2020";
    private static final String DATABASE = "mini";
    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private static String Driver = "com.mysql.cj.jdbc.Driver";

    public static String getUsername() {
        return USERNAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getDatabase() {
        return DATABASE;
    }

    public static String getUrl() {
        return URL;
    }

    public static String getDriver() {
        return Driver;
    }

    public static void setDriver(String driver) {
        Driver = driver;
    }

}
