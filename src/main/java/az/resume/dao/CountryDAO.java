package az.resume.dao;

import az.resume.bean.Country;

import java.sql.SQLException;
import java.util.List;

public abstract class CountryDAO {

    public  abstract Country countryById(int id) throws SQLException;

    public  abstract List<Country> getAll() throws SQLException;
}
