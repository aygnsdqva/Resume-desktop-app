package az.resume.dao;

import az.resume.bean.Country;
import az.resume.dao.model.Callable;

import java.sql.SQLException;
import java.util.List;

public abstract class CountryDAO {
    public  abstract List<Country> getAll() throws SQLException;
}
