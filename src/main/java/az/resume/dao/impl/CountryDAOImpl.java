package az.resume.dao.impl;

import az.resume.dao.CountryDAO;

import java.sql.Connection;

public class CountryDAOImpl extends CountryDAO {

    private Connection connection;

    public CountryDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
