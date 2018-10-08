package util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Connector {

    Connection connection;

    public Connector() {
        super();
        this.connection = getConnection();
    }

    public abstract Connection getConnection();

    public void init() {
        String sql =
                "CREATE TABLE userm (user_id BIGINT NOT NULL PRIMARY KEY, user_name VARCHAR(50), user_email VARCHAR(50), user_password VARCHAR(50), user_role VARCHAR(50))";
        String ins1 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (1, 'Igor', 'igor@mail.ru', '12345', 'admin')";
        String ins2 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (2, 'Harry', 'harry@mail.ru', '12345', 'user')";
        String ins3 =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (3, 'Joe', 'joe@mail.ru', '12345', 'manager')";

        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            stmt.executeUpdate(ins1);
            stmt.executeUpdate(ins2);
            stmt.executeUpdate(ins3);
            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
    };
}
