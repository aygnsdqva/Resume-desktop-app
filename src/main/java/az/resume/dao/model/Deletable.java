package az.resume.dao.model;

import java.sql.SQLException;

public interface Deletable {
    boolean delete(int id) throws SQLException;
}
