package az.resume.dao.impl;

import az.resume.bean.Certificate;
import az.resume.bean.User;
import az.resume.dao.CertificateDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CertificateDAOImpl extends CertificateDAO {

    private final Connection connection;

    public CertificateDAOImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public void add(Object object) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into certificate(name,organization,expiration_date,description,user_id) " + "values (?, ?, ?, ?, ? );");
        if (object instanceof Certificate certificate) {
            preparedStatement.setString(1, certificate.getName());
            preparedStatement.setString(2, certificate.getOrganization());
            preparedStatement.setDate(3, certificate.getExpirationDate());
            preparedStatement.setString(4, certificate.getDescription());
            preparedStatement.setInt(5, certificate.getUser().getId());
            preparedStatement.execute();
            System.out.println("Well done");
        }


    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<Certificate> userCertificates(int userId) throws SQLException {
        List<Certificate> certificates = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("select c.* from certificate c " + "left join user u on c.user_id = u.id " + "where c.user_id = ?");
        preparedStatement.setInt(1, userId);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String organization = resultSet.getString("organization");
            Date expirationDate = resultSet.getDate("expiration_date");
            String description = resultSet.getString("description");
            User user = new User();
            user.setId(userId);
            certificates.add(new Certificate(id, name, organization, expirationDate, description, user));
        }
        return certificates;
    }
}
