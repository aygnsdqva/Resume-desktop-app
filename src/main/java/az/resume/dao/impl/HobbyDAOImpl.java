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
    public void add(Hobby hobby) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into hobby(name,user_id) " + "values (?,  ?)");
        preparedStatement.setString(1, hobby.getName());
        preparedStatement.setInt(2, hobby.getUser().getId());
    }

    @Override
    public Hobby hobbyById(int id) throws SQLException {
        Hobby hobby = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from hobby where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int userId = resultSet.getInt("user_id");
            User user = new User();
            user.setId(userId);
            hobby = new Hobby(id, name, user);
        }
        return hobby;
    }

    @Override
    public boolean update(Hobby hobby) throws SQLException {
        if (hobbyById(hobby.getId()) == null) return false;
        Hobby hobbyByDB = hobbyById(hobby.getId());
        String name = (hobby.getName() != null ? hobby.getName() : hobbyByDB.getName());
        PreparedStatement preparedStatement = connection.prepareStatement("update hobby set name = ? where id = ? ");
        preparedStatement.setString(1, name);
        preparedStatement.execute();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (hobbyById(id) == null) return false;
        PreparedStatement preparedStatement = connection.prepareStatement("delete from hobby where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return true;
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
