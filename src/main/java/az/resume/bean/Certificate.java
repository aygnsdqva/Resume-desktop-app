package az.resume.bean;

import java.util.Date;

public class Certificate {
    private int id;
    private String name;
    private String organization;
    private Date expirationDate;
    private String description;
    private User user;

    public Certificate() {
    }

    public Certificate(int id, String name, String organization, Date expirationDate, String description, User user) {
        this.id = id;
        this.name = name;
        this.organization = organization;
        this.expirationDate = expirationDate;
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String result = "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organization='" + organization + '\'';
        if (expirationDate!= null){
            result  += (", expirationDate=" + expirationDate + '\'');
        }
        if(description!=null){
            result += ", description='" + description + '\'';
        }
        result+= ", user=" + user +
                '}';
        return result;
    }
}
