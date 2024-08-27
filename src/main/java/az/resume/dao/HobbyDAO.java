package az.resume.dao;

import az.resume.bean.Hobby;
import az.resume.dao.model.Deletable;
import az.resume.dao.model.Insertable;
import az.resume.dao.model.Updatable;

import java.sql.SQLException;
import java.util.List;

public abstract class HobbyDAO implements Insertable, Updatable, Deletable {
    public abstract List<Hobby> userHobbies(int userId) throws SQLException;
}
