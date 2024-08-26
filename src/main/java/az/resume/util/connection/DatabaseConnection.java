package az.resume.util.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnection {

    Connection getConnection();

    void closeConnection() throws SQLException;
}
