package az.resume.dao;

import az.resume.bean.University;
import az.resume.bean.UserEducation;

import java.sql.SQLException;
import java.util.List;

public abstract class UniversityDAO {
    public  abstract List<University> getAll() throws SQLException;
    public abstract List<UserEducation> getUserEducations(int userId) throws SQLException;
}
