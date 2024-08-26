package az.resume.main;


import java.sql.*;

public class Main {

    public static void foo() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3300/resume";
        String username = "root";
        String password = "root123";

        Connection c = DriverManager.getConnection(url,username,password);
        Statement statement = c.createStatement();
        statement.execute("select * from country;");
        ResultSet resultSet =  statement.getResultSet();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("country_name");
//            String surname = resultSet.getString("surname");
//            String email = resultSet.getString("email");
//            String phone = resultSet.getString("phone");
            System.out.println(id + " " + name );
        }
        System.out.println(c.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        foo();
    }
}