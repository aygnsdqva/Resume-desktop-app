package az.resume.dao.impl;

import az.resume.bean.*;
import az.resume.contex.InitialClass;
import az.resume.dao.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends UserDAO {

    private final Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("SELECT u.* , c.country_name, n.nationality_iso as nationality " + "FROM user u " + "left join country c on u.country_id = c.id " + "left join country n on u.nationality_id = n.id");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String about = resultSet.getString("about");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("country_name");
            int nationalityId = resultSet.getInt("nationality_id");
            String nationalityName = resultSet.getString("nationality");
            users.add(new User(id, name, surname, email, phone, about, new Country(countryId, countryName, null), new Country(nationalityId, null, nationalityName), null, null, null, null, null, null));


        }
        return users;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        User user = null;
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT u.* , c.country_name, n.nationality_iso as nationality " + "FROM user u " + "left join country c on u.country_id = c.id " + "left join country n on u.nationality_id = n.id " + "where u.id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String about = resultSet.getString("about");
            int countryId = resultSet.getInt("country_id");
            String countryName = resultSet.getString("country_name");
            int nationalityId = resultSet.getInt("nationality_id");
            String nationalityName = resultSet.getString("nationality");
            List<Certificate> certificates = InitialClass.initialCertificateDAO(connection).userCertificates(id);
            List<Experience> experiences = InitialClass.initialExperienceDAO(connection).userExperiences(id);
            List<Hobby> hobbies = InitialClass.initialHobbyDAO(connection).userHobbies(id);
            List<UserEducation> educations = InitialClass.initialUniversityDAO(connection).getUserEducations(id);
            List<UserLanguage> languages = InitialClass.initialLanguageDAO(connection).getUserLanguages(id);
            List<UserSkill> skills = InitialClass.initialSkillDAO(connection).getUserSkills(id);
            user = new User(id, name, surname, email, phone, about, new Country(countryId, countryName, null), new Country(nationalityId, null, nationalityName), certificates, experiences, hobbies, educations, languages, skills);
        }
        return user;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void add(User user) {

    }


    @Override
    public void update(int id) {

    }
}
