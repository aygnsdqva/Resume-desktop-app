package az.resume.dao.impl;

import az.resume.bean.Country;
import az.resume.dao.CountryDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl extends CountryDAO {

    private final Connection connection;

    public CountryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Country> getAll() throws SQLException {
        List<Country> countries = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select c.id, c.country_name as name, c.nationality_iso as nationality " + "from country c ");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String countryName = resultSet.getString("name");
            String nationality = resultSet.getString("nationality");
            countries.add(new Country(id, countryName, nationality));
            System.out.println("ID " + ColorUtil.greenColorBold(id) + ", country name: " + ColorUtil.redColor(countryName) + ", nationality is " + ColorUtil.redColor(nationality));
        }

        return countries;
    }
}
