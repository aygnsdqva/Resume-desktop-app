package az.resume.contex;

import az.resume.dao.*;
import az.resume.dao.impl.*;
import az.resume.util.connection.DatabaseConnection;
import az.resume.util.connection.impl.MySqlDatabaseConnectionImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class InitialClass {


    public static DatabaseConnection initialMySqlDatabase(String url, String username, String password) throws SQLException {
        return new MySqlDatabaseConnectionImpl(url, username, password);
    }

    public static UserDAO initialUserDAO(Connection connection) {
        return new UserDAOImpl(connection);
    }

    public static CertificateDAO initialCertificateDAO(Connection connection) {
        return new CertificateDAOImpl(connection);
    }

    public static CountryDAO initialCountryDAO(Connection connection) {
        return new CountryDAOImpl(connection);
    }

    public static DegreeDAO initialDegreeDAO(Connection connection) {
        return new DegreeDAOImpl(connection);
    }

    public static ExperienceDAO initialExperienceDAO(Connection connection) {
        return new ExperienceDAOImpl(connection);
    }

    public static HobbyDAO initialHobbyDAO(Connection connection) {
        return new HobbyDAOImpl(connection);
    }

    public static LanguageDAO initialLanguageDAO(Connection connection) {
        return new LanguageDAOImpl(connection);
    }

    public static ProfessionDAO initialProfessionDAO(Connection connection) {
        return new ProfessionDAOImpl(connection);
    }

    public static SkillDAO initialSkillDAO(Connection connection) {
        return new SkillDAOImpl(connection);
    }

    public static UniversityDAO initialUniversityDAO(Connection connection) {
        return new UniversityDAOImpl(connection);
    }
}
