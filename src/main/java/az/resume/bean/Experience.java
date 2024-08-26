package az.resume.bean;

import java.util.Date;

public class Experience {
    private int id;
    private String header;
    private Date beginDate;
    private Date endDate;
    private String description;
    private User user;

    public Experience() {
    }

    public Experience(int id, String header, Date beginDate, Date endDate, String description, User user) {
        this.id = id;
        this.header = header;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.description = description;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        String result = "Experience{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", beginDate=" + beginDate;
        if (endDate!=null){
            result += ", endDate=" + endDate ;
        }
        result +=", description='" + description + '\'' +
                ", user=" + user +
                '}';

        return result;
    }
}
