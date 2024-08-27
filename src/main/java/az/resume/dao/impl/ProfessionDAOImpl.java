package az.resume.dao.impl;

import az.resume.bean.Profession;
import az.resume.dao.ProfessionDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessionDAOImpl extends ProfessionDAO {
    private final Connection connection;

    public ProfessionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Profession> getAll() throws SQLException {
        List<Profession> professions = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select * from profession");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            professions.add(new Profession(id,name));
        }
        return  professions;
    }
}
