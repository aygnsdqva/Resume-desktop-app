package az.resume.util.connection.impl;

import az.resume.util.connection.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDatabaseConnectionImpl implements DatabaseConnection {

    private  Connection connection;

    public MySqlDatabaseConnectionImpl() {
    }

    public MySqlDatabaseConnectionImpl(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url,username,password);
    }


    @Override
    public Connection getConnection() {
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }


}
