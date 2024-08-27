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
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into employment_history(header,begin_date,end_date,description,user_id) " + "values (?, ?, ?, ?, ?)");
        if (object instanceof Experience experience) {
            preparedStatement.setString(1, experience.getHeader());
            preparedStatement.setDate(2, experience.getBeginDate());
            preparedStatement.setDate(3, experience.getEndDate());
            preparedStatement.setString(4, experience.getDescription());
            preparedStatement.setInt(5, experience.getUser().getId());
            preparedStatement.execute();
            System.out.println("Well done");

        }
    }

    @Override
    public void update(int id) {

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
