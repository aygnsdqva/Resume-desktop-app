package az.resume.dao.impl;

import az.resume.bean.Certificate;
import az.resume.bean.User;
import az.resume.contex.InitialClass;
import az.resume.dao.CertificateDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertificateDAOImpl extends CertificateDAO {

    private Connection connection;

    public CertificateDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into certificate(name,organization,expiration_date,description,user_id) " +
                "values (?, ?, ?, ?, ? );");
        if(object instanceof Certificate){
            Certificate certificate = (Certificate) object;
            preparedStatement.setString(1,certificate.getName());
            preparedStatement.setString(2,certificate.getOrganization());
            preparedStatement.setDate(3,certificate.getExpirationDate());
            preparedStatement.setString(4,certificate.getDescription());
            preparedStatement.setInt(5,certificate.getUser().getId());
            preparedStatement.execute();
            System.out.println("Well done");
        }


    }

    @Override
    public void update(int id) {

    }
}
