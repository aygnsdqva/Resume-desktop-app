package az.resume.dao.impl;

import az.resume.bean.Language;
import az.resume.bean.User;
import az.resume.bean.UserLanguage;
import az.resume.dao.LanguageDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDAOImpl extends LanguageDAO {

    private final Connection connection;

    public LanguageDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Language> getAll() throws SQLException {
        List<Language> languages = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("select * from language");
        ResultSet resultSet = statement.getResultSet();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            languages.add(new Language(id,name));
        }
        return  languages;
    }

    @Override
    public List<UserLanguage> getUserLanguages(int userId) throws SQLException {
        List<UserLanguage> userLanguages = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select  ul.user_id, ul.id user_language_id, " +
                "ul.language_id, l.name language_name, ul.power " +
                "from user_language ul " +
                "join language l on ul.language_id = l.id " +
                "where ul.user_id = ?");
        preparedStatement.setInt(1,userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            int userLanguageId = resultSet.getInt("user_language_id");
            int languageId = resultSet.getInt("language_id");
            String languageName = resultSet.getString("language_name");
            int power = resultSet.getInt("power");
            User user = new User();
            user.setId(userId);
            userLanguages.add(new UserLanguage(userLanguageId,user,new Language(languageId,languageName),power));
        }
        return  userLanguages;
    }
}
