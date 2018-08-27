package util;

import java.sql.Connection;

public interface Connector {

    Connection getConnection();

    void init();
}
