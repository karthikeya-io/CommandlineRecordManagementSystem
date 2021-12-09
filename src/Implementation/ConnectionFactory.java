package Implementation;

import SQLDetails.Details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import Interfaces.CONNECTable;

public class ConnectionFactory implements CONNECTable {

    @Override
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(Details.getDriver());

            Properties connectionProps = new Properties();
            connectionProps.put("user", Details.getUsername());
            connectionProps.put("password", Details.getPassword());
            con = DriverManager.getConnection(Details.getUrl(), connectionProps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}