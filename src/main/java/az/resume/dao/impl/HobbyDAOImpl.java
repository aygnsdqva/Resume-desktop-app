package az.resume.dao.impl;

import az.resume.dao.HobbyDAO;

import java.sql.Connection;

public class HobbyDAOImpl extends HobbyDAO {

    private Connection connection;

    public HobbyDAOImpl(Connection connection) {
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
