package az.resume.dao;

import az.resume.bean.Experience;
import az.resume.dao.model.Deletable;

import java.sql.SQLException;
import java.util.List;

public abstract class ExperienceDAO implements Deletable {
    public abstract List<Experience> userExperiences(int userId) throws SQLException;

    public abstract boolean update(Experience experience) throws SQLException;

    public abstract void add(Experience experience) throws SQLException;

    public abstract Experience experienceById(int id) throws SQLException;
}
