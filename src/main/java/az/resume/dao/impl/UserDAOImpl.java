package az.resume.dao.impl;

import az.resume.dao.UserDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAOImpl extends UserDAO {

    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("SELECT u.* , c.country_name, n.nationality_iso as nationality " +
                "FROM user u " +
                "left join country c on u.country_id = c.id " +
                "left join country n on u.nationality_id = n.id");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String about = resultSet.getString("about");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("country_name");
            int nationalityId = resultSet.getInt("nationality_id");
            String nationalityName = resultSet.getString("nationality");
            System.out.println("ID: " + ColorUtil.greenColorBold(id)
                    + ", Name: " + ColorUtil.redColor(name) + ", Surname: " + ColorUtil.redColor(surname)
                    + ", Email: " + ColorUtil.blueColor(email) + ", Phone: " + ColorUtil.blueColor(phone)
                    + ", About: " + ColorUtil.purpleColor(about)
                    + ", Country ID: " + ColorUtil.greenColorBold(countryId)
                    + ", Country Name: " + ColorUtil.redColor(countryName)
                    + ", Nationality ID: " + ColorUtil.greenColorBold(countryName)
                    + ", Nationality Name: " + ColorUtil.redColor(nationalityName));

        }
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void update(int id) {

    }
}
