package az.resume.dao.impl;

import az.resume.dao.ExperienceDAO;

import java.sql.Connection;

public class ExperienceDAOImpl extends ExperienceDAO {

    private Connection connection;

    public ExperienceDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void update(int id) {

    }
}
