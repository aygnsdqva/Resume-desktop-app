package az.resume.dao.impl;

import az.resume.bean.Hobby;
import az.resume.bean.User;
import az.resume.dao.HobbyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HobbyDAOImpl extends HobbyDAO {

    private final Connection connection;

    public HobbyDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into hobby(name,user_id) " + "values (?,  ?)");
        if (object instanceof Hobby hobby) {
            preparedStatement.setString(1, hobby.getName());
            preparedStatement.setInt(2, hobby.getUser().getId());
        }
    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<Hobby> userHobbies(int userId) throws SQLException {
        List<Hobby> hobbies = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select h.* from hobby h " + "left join user u on h.user_id = u.id " + "where h.user_id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            User user = new User();
            user.setId(userId);
            hobbies.add(new Hobby(id, name, user));
        }
        return hobbies;
    }
}
