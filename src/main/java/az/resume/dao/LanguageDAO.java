package az.resume.dao;

import az.resume.bean.Language;
import az.resume.bean.UserLanguage;

import java.sql.SQLException;
import java.util.List;

public abstract class LanguageDAO{
    public abstract List<Language> getAll() throws SQLException;
    public abstract List<UserLanguage> getUserLanguages(int userId) throws SQLException;
}
