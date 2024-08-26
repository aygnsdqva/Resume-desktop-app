package az.resume.dao.impl;

import az.resume.dao.SkillDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SkillDAOImpl extends SkillDAO {

    private Connection connection;

    public SkillDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from skill");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + ColorUtil.greenColorBold(id) + ", skill: " + ColorUtil.redColor(name));
        }
    }
}
