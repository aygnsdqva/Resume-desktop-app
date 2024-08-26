package az.resume.dao.model;

import az.resume.bean.User;

import java.sql.SQLException;

public interface Insertable {
    void add(Object object) throws SQLException;
}
