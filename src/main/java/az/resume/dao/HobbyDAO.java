package az.resume.dao;

import az.resume.bean.Hobby;
import az.resume.dao.model.Deletable;

import java.sql.SQLException;
import java.util.List;

public abstract class HobbyDAO implements Deletable {
    public abstract List<Hobby> userHobbies(int userId) throws SQLException;

    public abstract boolean update(Hobby hobby) throws SQLException;

    public abstract void add(Hobby hobby) throws SQLException;

    public abstract Hobby hobbyById(int id) throws SQLException;
}
