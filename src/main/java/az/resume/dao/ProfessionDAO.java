package az.resume.dao;

import az.resume.bean.Profession;

import java.sql.SQLException;
import java.util.List;

public abstract class ProfessionDAO{
    public abstract List<Profession> getAll() throws SQLException;
}
