package az.resume.dao.impl;

import az.resume.dao.DegreeDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DegreeDAOImpl extends DegreeDAO {

    private Connection connection;

    public DegreeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getAll() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("select * from degree");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            System.out.println("ID: " + ColorUtil.greenColorBold(id) + ", name: " + ColorUtil.redColor(name));
        }
    }
}
