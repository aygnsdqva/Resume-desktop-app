package az.resume.dao.impl;

import az.resume.bean.*;
import az.resume.dao.UniversityDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDAOImpl extends UniversityDAO {
    private final Connection connection;

    public UniversityDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<University> getAll() throws SQLException {
        List<University> universities = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select u.*, c.country_name from university u " +
                "left join country c on u.country_id = c.id");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("country_name");
            universities.add(new University(id, name, new Country(countryId, countryName, null)));
        }
        return universities;

    }

    @Override
    public List<UserEducation> getUserEducations(int userId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT e.id education_id, " + "e.university_id, un.name university_name, " + "un.country_id, c.country_name university_country, " + "e.profession_id, p.name profession_name, " + "e.degree_id, d.name degree_name " + "FROM user u " + "join user_education e on e.user_id = u.id " + "join university un on e.university_id = un.id " + "join country c on un.country_id = c.id " + "join profession p on e.profession_id = p.id " + "join degree d on e.degree_id = d.id " + "where u.id=?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        List<UserEducation> userEducations = new ArrayList<>();
        while (resultSet.next()) {
            int educationId = resultSet.getInt("education_id");
            int universityId = resultSet.getInt("university_id");
            String universityName = resultSet.getString("university_name");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("university_country");
            int professionId = resultSet.getInt("profession_id");
            String professionName = resultSet.getString("profession_name");
            int degreeId = resultSet.getInt("degree_id");
            String degreeName = resultSet.getString("degree_name");
            User user = new User();
            user.setId(userId);
            UserEducation userEducation = new UserEducation(educationId, user, new University(universityId, universityName, new Country(countryId, countryName, null)), new Profession(professionId, professionName), new Degree(degreeId, degreeName));
            userEducations.add(userEducation);
        }
        return userEducations;
    }
}
