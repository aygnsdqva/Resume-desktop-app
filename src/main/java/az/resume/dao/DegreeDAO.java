package az.resume.dao;

import az.resume.bean.Degree;

import java.sql.SQLException;
import java.util.List;

public abstract class DegreeDAO {
    public abstract List<Degree> getAll() throws SQLException;
}
