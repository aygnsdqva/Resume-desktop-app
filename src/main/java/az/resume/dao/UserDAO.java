package az.resume.dao;

import az.resume.bean.User;
import az.resume.dao.model.*;

import java.sql.SQLException;
import java.util.List;

public abstract class UserDAO implements Updatable, Deletable {
    public abstract void add(User user);

    public abstract List<User> getAll() throws SQLException;

    public abstract User getUserById(int userId) throws SQLException;


}
