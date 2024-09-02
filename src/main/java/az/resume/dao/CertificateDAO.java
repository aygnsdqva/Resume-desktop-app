package az.resume.dao;

import az.resume.bean.Certificate;
import az.resume.dao.model.Deletable;

import java.sql.SQLException;
import java.util.List;

public abstract class CertificateDAO implements  Deletable {

    public abstract List<Certificate> userCertificates(int userId) throws SQLException;

    public abstract void add(Certificate certificate) throws SQLException;

    public abstract Certificate certificateById(int id) throws SQLException;

    public abstract boolean update(Certificate certificate) throws SQLException;


}
