package az.resume.dao.impl;

import az.resume.bean.Experience;
import az.resume.bean.User;
import az.resume.dao.ExperienceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExperienceDAOImpl extends ExperienceDAO {

    private Connection connection;

    public ExperienceDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into employment_history(header,begin_date,end_date,description,user_id) " +
                "values (?, ?, ?, ?, ?)");
        if(object instanceof Experience){
            Experience experience = (Experience) object;
            preparedStatement.setString(1,experience.getHeader());
            preparedStatement.setDate(2,experience.getBeginDate());
            preparedStatement.setDate(3,experience.getEndDate());
            preparedStatement.setString(4,experience.getDescription());
            preparedStatement.setInt(5,experience.getUser().getId());
            preparedStatement.execute();
            System.out.println("Well done");

        }
    }

    @Override
    public void update(int id) {

    }
}
