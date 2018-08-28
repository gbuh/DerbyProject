package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Connector implements Connector {

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

    @Override
    public void init() {
        String sql =
                "CREATE TABLE userm (user_id BIGINT NOT NULL PRIMARY KEY, user_name VARCHAR(50), user_email VARCHAR(50), user_password VARCHAR(50), user_role VARCHAR(50))";
        String ins1 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (1, 'Igor', 'igor@mail.ru', '12345', 'admin')";
        String ins2 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (2, 'Harry', 'harry@mail.ru', '12345', 'user')";

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.executeUpdate();
            PreparedStatement ps1 = connection.prepareStatement(ins1);
            ps1.executeUpdate();
            PreparedStatement ps2 = connection.prepareStatement(ins2);
            ps2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
