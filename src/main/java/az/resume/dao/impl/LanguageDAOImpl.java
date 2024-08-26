package az.resume.dao.impl;

import az.resume.dao.LanguageDAO;

import java.sql.Connection;

public class LanguageDAOImpl extends LanguageDAO {

    private Connection connection;

    public LanguageDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
