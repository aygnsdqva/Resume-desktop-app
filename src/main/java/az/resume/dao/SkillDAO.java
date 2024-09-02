package az.resume.dao;

import az.resume.bean.Skill;
import az.resume.bean.UserSkill;
import az.resume.dao.model.Deletable;

import java.sql.SQLException;
import java.util.List;

public abstract class SkillDAO implements Deletable {
    public abstract List<Skill> getAll() throws SQLException;

    public abstract List<UserSkill> getUserSkills(int userId) throws SQLException;

    public abstract void add(Skill skill) throws SQLException;

    public abstract Skill skillById(int id) throws SQLException;

    public abstract boolean update(Skill skill) throws SQLException;
}
