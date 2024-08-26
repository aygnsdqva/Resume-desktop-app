package az.resume.main;


import az.resume.contex.InitialClass;
import az.resume.util.connection.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3300/resume";
        String username = "root";
        String password = "root123";
        DatabaseConnection databaseConnection = InitialClass.initialMySqlDatabase(url, username, password);
        InitialClass.initialUserDAO(databaseConnection.getConnection()).getAll();
        databaseConnection.closeConnection();
    }


}