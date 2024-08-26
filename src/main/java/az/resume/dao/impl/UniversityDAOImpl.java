package az.resume.dao.impl;

import az.resume.dao.UniversityDAO;

import java.sql.Connection;

public class UniversityDAOImpl extends UniversityDAO {
    private Connection connection;

    public UniversityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
