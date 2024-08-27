package az.resume.dao.impl;

import az.resume.bean.Degree;
import az.resume.dao.DegreeDAO;
import az.resume.util.color.ColorUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DegreeDAOImpl extends DegreeDAO {

    private final Connection connection;

    public DegreeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Degree> getAll() throws SQLException {
        List<Degree> degrees = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select * from degree");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            degrees.add(new Degree(id, name));
            System.out.println("ID: " + ColorUtil.greenColorBold(id) + ", name: " + ColorUtil.redColor(name));
        }
        return degrees;
    }
}
