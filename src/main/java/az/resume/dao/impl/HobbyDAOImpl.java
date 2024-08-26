package az.resume.dao.impl;

import az.resume.bean.Hobby;
import az.resume.bean.User;
import az.resume.dao.HobbyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HobbyDAOImpl extends HobbyDAO {

    private Connection connection;

    public HobbyDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into hobby(name,user_id) " +
                "values (?,  ?)");
        if(object instanceof Hobby){
            Hobby hobby = (Hobby) object;
            preparedStatement.setString(1, hobby.getName());
            preparedStatement.setInt(2, hobby.getUser().getId());
        }
    }

    @Override
    public void update(int id) {

    }
}
