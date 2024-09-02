package az.resume.dao.impl;

import az.resume.bean.Country;
import az.resume.dao.CountryDAO;
import az.resume.util.color.ColorUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAOImpl extends CountryDAO {

    private final Connection connection;

    public CountryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Country countryById(int id) throws SQLException {
        Country country = null;
        PreparedStatement statement = connection.prepareStatement("select * from country where id = ?;");
        statement.setInt(1, id);
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            String countryName = resultSet.getString("country_name");
            String nationality = resultSet.getString("nationality_iso");
            country = new Country(id, countryName,nationality);
        }
        return country;
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
