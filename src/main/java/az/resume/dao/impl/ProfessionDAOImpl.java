package az.resume.dao.impl;

import az.resume.dao.ProfessionDAO;

import java.sql.Connection;

public class ProfessionDAOImpl extends ProfessionDAO {
    private Connection connection;

    public ProfessionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
