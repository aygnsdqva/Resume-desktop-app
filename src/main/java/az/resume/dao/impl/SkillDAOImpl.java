package az.resume.dao.impl;

import az.resume.bean.Language;
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

    @Override
    public void add(Object object) throws SQLException {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}
