package az.resume.dao.impl;

import az.resume.dao.SkillDAO;

import java.sql.Connection;

public class SkillDAOImpl extends SkillDAO {

    private Connection connection;

    public SkillDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() {

    }
}
