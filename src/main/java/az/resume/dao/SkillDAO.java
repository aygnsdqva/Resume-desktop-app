package az.resume.dao;

import az.resume.bean.Skill;
import az.resume.bean.UserSkill;
import az.resume.dao.model.Deletable;
import az.resume.dao.model.Insertable;
import az.resume.dao.model.Updatable;

import java.sql.SQLException;
import java.util.List;

public abstract class SkillDAO implements  Insertable, Updatable, Deletable {
    public abstract List<Skill> getAll() throws SQLException;
    public abstract List<UserSkill> getUserSkills(int userId) throws SQLException;
}
