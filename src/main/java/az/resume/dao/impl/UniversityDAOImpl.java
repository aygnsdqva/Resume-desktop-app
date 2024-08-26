package az.resume.dao.impl;

import az.resume.dao.UniversityDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversityDAOImpl extends UniversityDAO {
    private Connection connection;

    public UniversityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select u.*, c.country_name from university u " +
                "left join country c on u.country_id = c.id");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("country_name");
            System.out.println("ID: " + ColorUtil.greenColorBold(id)
                    + ", skill: " + ColorUtil.redColor(name)
                    + ", country id: " + ColorUtil.greenColorBold(countryId)
                    + ", country name: " + ColorUtil.redColor(countryName));
        }

    }
}
