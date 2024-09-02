package az.resume.dao;

import az.resume.bean.User;
import az.resume.dao.model.*;

import java.sql.SQLException;
import java.util.List;

public abstract class UserDAO implements Deletable {
    public abstract void add(User user) throws SQLException;

    public abstract List<User> getAll() throws SQLException;

    public abstract User getUserById(int userId) throws SQLException;

    public abstract boolean update(User user) throws  SQLException;




}
