package az.resume.dao.impl;

import az.resume.dao.CertificateDAO;

import java.sql.Connection;

public class CertificateDAOImpl extends CertificateDAO {

    private Connection connection;

    public CertificateDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void getById(int id) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void update(int id) {

    }
}
