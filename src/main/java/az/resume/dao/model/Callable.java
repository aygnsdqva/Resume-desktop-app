package az.resume.dao.model;

import java.sql.SQLException;
import java.util.List;

public interface Callable {
    List<Object> getAll() throws SQLException;
}
