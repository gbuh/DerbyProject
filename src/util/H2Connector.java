package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connector extends Connector {

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:.testdb");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
