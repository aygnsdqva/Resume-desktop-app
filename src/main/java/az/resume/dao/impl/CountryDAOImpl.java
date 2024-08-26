package az.resume.dao.impl;

import az.resume.dao.CountryDAO;
import az.resume.util.color.ColorEnum;
import az.resume.util.color.ColorUtil;
import az.resume.util.color.FormatEnum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryDAOImpl extends CountryDAO {

    private Connection connection;

    public CountryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select c.id, c.country_name as name, c.nationality_iso as nationality " +
                "from country c ");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String  countryName = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            System.out.println("ID " + ColorUtil.greenColorBold(id)
                                + ", country name: " + ColorUtil.redColor(countryName)
                                + ", nationality is " + ColorUtil.redColor(nationality));
        }

    }
}
