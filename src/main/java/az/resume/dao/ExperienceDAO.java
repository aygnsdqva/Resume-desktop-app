package az.resume.dao;

import az.resume.bean.Experience;
import az.resume.dao.model.Deletable;
import az.resume.dao.model.Insertable;
import az.resume.dao.model.Updatable;

import java.sql.SQLException;
import java.util.List;

public abstract class ExperienceDAO implements Insertable, Updatable, Deletable {
    public abstract List<Experience> userExperiences(int userId) throws SQLException;
}
