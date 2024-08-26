package az.resume.dao.impl;

import az.resume.dao.UserDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDAOImpl extends UserDAO {

    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
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
