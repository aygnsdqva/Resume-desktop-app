package az.resume.dao;

import az.resume.bean.Certificate;
import az.resume.dao.model.Deletable;
import az.resume.dao.model.Insertable;
import az.resume.dao.model.Updatable;

import java.sql.SQLException;
import java.util.List;

public abstract class CertificateDAO implements Insertable, Updatable, Deletable {
    public abstract List<Certificate> userCertificates(int userId) throws SQLException;
}
