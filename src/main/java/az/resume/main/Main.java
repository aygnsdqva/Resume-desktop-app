package az.resume.main;

import az.resume.contex.InitialClass;
import az.resume.util.connection.DatabaseConnection;
import az.resume.util.connection.impl.MySqlDatabaseConnectionImpl;



public class Main {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3300/resume";
        String username = "root";
        String password = "root123";
        DatabaseConnection databaseConnection = InitialClass.initialMySqlDatabase(url, username, password);
        InitialClass.initialExperienceDAO(databaseConnection.getConnection());
        new MySqlDatabaseConnectionImpl().closeConnection();
    }


}