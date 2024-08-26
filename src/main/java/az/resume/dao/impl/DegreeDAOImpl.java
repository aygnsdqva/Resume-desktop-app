package az.resume.dao.impl;

import az.resume.dao.DegreeDAO;

import java.sql.Connection;

public class DegreeDAOImpl extends DegreeDAO {

    private Connection connection;

    public DegreeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
