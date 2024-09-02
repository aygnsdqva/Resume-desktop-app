package az.resume.dao.impl;

import az.resume.bean.Experience;
import az.resume.bean.User;
import az.resume.dao.ExperienceDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExperienceDAOImpl extends ExperienceDAO {

    private final Connection connection;

    public ExperienceDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Experience experience) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into employment_history(header,begin_date,end_date,description,user_id) " + "values (?, ?, ?, ?, ?)");
        preparedStatement.setString(1, experience.getHeader());
        preparedStatement.setDate(2, experience.getBeginDate());
        preparedStatement.setDate(3, experience.getEndDate());
        preparedStatement.setString(4, experience.getDescription());
        preparedStatement.setInt(5, experience.getUser().getId());
        preparedStatement.execute();
        System.out.println("Well done");
    }

    @Override
    public Experience experienceById(int id) throws SQLException {
        Experience experience = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from employment_history where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            String header = resultSet.getString("header");
            Date beginDate = resultSet.getDate("begin_date");
            Date endDate = resultSet.getDate("end_date");
            String description = resultSet.getString("description");
            int userId = resultSet.getInt("user_id");
            User user = new User();
            user.setId(userId);
            experience = new Experience(id, header, beginDate, endDate, description, user);
        }
        return experience;
    }

    @Override
    public boolean update(Experience experience) throws SQLException {
        if (experienceById(experience.getId()) == null) return false;
        Experience dbExperience = experienceById(experience.getId());
        String header = (experience.getHeader() != null ? experience.getHeader() : dbExperience.getHeader());
        Date beginDate = (experience.getBeginDate() != null ? experience.getBeginDate() : dbExperience.getBeginDate());
        Date endDate = (experience.getEndDate() != null ? experience.getEndDate() : dbExperience.getEndDate());
        String description = (experience.getDescription() != null ? experience.getDescription() : dbExperience.getDescription());
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employment_history SET `header` = ?, `begin_date` = ?, `end_date` = ?, `description` = ? WHERE (`id` = ?)");
        preparedStatement.setString(1, header);
        preparedStatement.setDate(2, beginDate);
        preparedStatement.setDate(3, endDate);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, experience.getId());
        preparedStatement.execute();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (experienceById(id) == null) return false;
        PreparedStatement preparedStatement = connection.prepareStatement("delete from employment_history where  id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return true;
    }

    @Override
    public List<Experience> userExperiences(int userId) throws SQLException {
        List<Experience> experiences = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select e.* from employment_history e " + "left join user u on e.user_id = u.id " + "where e.user_id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String header = resultSet.getString("header");
            Date beginDate = resultSet.getDate("begin_date");
            Date endDate = resultSet.getDate("end_date");
            String description = resultSet.getString("description");
            User user = new User();
            user.setId(userId);
            experiences.add(new Experience(id, header, beginDate, endDate, description, user));
        }
        return experiences;
    }
}
