package az.resume.bean;

public class UserEducation {
    private int id;
    private User user;
    private University university;
    private Profession profession;
    private Degree degree;

    public UserEducation(int id, User user, University university, Profession profession, Degree degree) {
        this.id = id;
        this.user = user;
        this.university = university;
        this.profession = profession;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "UserEducation{" + "id=" + id + ", userId=" + user.getId() + ", university=" + university + ", profession=" + profession + ", degree=" + degree + '}';
    }
}
