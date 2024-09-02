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
    public void add(Certificate certificate) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into certificate(name,organization,expiration_date,description,user_id) " + "values (?, ?, ?, ?, ? );");
        preparedStatement.setString(1, certificate.getName());
        preparedStatement.setString(2, certificate.getOrganization());
        preparedStatement.setDate(3, certificate.getExpirationDate());
        preparedStatement.setString(4, certificate.getDescription());
        preparedStatement.setInt(5, certificate.getUser().getId());
        preparedStatement.executeUpdate();
        System.out.println("Well done");

    }

    @Override
    public Certificate certificateById(int id) throws SQLException {
        Certificate certificate = null;
        PreparedStatement preparedStatement = connection.prepareStatement("select * from certificate " + "where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {
            int certificateId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String organization = resultSet.getString("organization");
            Date expirationDate = resultSet.getDate("expiration_date");
            String description = resultSet.getString("description");
            User user = new User();
            user.setId(resultSet.getInt("user_id"));
            certificate = new Certificate(certificateId, name, organization, expirationDate, description, user);
        }
        return certificate;
    }


    @Override
    public boolean update(Certificate certificate) throws SQLException {
        if (certificateById(certificate.getId()) == null) return false;

        Certificate dbCertificate = certificateById(certificate.getId());
        String name = (certificate.getName() != null ? certificate.getName() : dbCertificate.getName());
        String organization = (certificate.getOrganization() != null ? certificate.getOrganization() : dbCertificate.getOrganization());
        Date expirationDate = (certificate.getExpirationDate() != null ? certificate.getExpirationDate() : dbCertificate.getExpirationDate());
        String description = (certificate.getDescription() != null ? certificate.getDescription() : dbCertificate.getDescription());

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE certificate SET `name` = ?, `organization` = ?, " + "`expiration_date` = ?, `description` = ? WHERE (`id` = ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, organization);
        preparedStatement.setDate(3, expirationDate);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, certificate.getId());
        preparedStatement.execute();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        if (certificateById(id) == null) return false;

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM certificate WHERE (`id` = ?)");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        return true;
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
