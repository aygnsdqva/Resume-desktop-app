package az.resume.dao.impl;

import az.resume.bean.Skill;
import az.resume.bean.User;
import az.resume.bean.UserSkill;
import az.resume.dao.SkillDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAOImpl extends SkillDAO {

    private final Connection connection;

    public SkillDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void add(Skill skill) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into skill(name) value (?)");
        preparedStatement.setString(1, skill.getName());
        preparedStatement.executeUpdate();
        System.out.println("Well done");
    }

    @Override
    public Skill skillById(int id) throws SQLException {
        Skill skill = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from skill where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            skill = new Skill(id, name);
        }
        return skill;
    }

    @Override
    public boolean update(Skill skill) throws SQLException {
        if (skillById(skill.getId()) == null) return false;
        Skill skillByDb = skillById(skill.getId());
        String name = (skill.getName() != null ? skill.getName() : skillByDb.getName());
        PreparedStatement preparedStatement = connection.prepareStatement("update skill set name = ? where id = ?");
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, skill.getId());
        preparedStatement.executeUpdate();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (skillById(id) == null) return false;
        PreparedStatement preparedStatement = connection.prepareStatement("delete from skill where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        return true;
    }

    @Override
    public List<Skill> getAll() throws SQLException {
        List<Skill> skills = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select * from skill");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            skills.add(new Skill(id, name));
        }
        return skills;
    }

    @Override
    public List<UserSkill> getUserSkills(int userId) throws SQLException {
        List<UserSkill> userSkills = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT us.user_id, us.id user_skill_id, " + "us.skil_id skill_id, s.name skill_name,  " + "us.power " + "FROM user_skill us " + "join skill s on  us.skil_id=s.id " + "where us.user_id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int userSkillId = resultSet.getInt("user_skill_id");
            int skillId = resultSet.getInt("skill_id");
            String skillName = resultSet.getString("skill_name");
            int power = resultSet.getInt("power");
            User user = new User();
            user.setId(userId);
            userSkills.add(new UserSkill(userSkillId, user, new Skill(skillId, skillName), power));
        }
        return userSkills;
    }

}
