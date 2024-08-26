package az.resume.bean;

public class UserSkill {
    private int id;
    private User user;
    private Language language;
    private int power ;

    public UserSkill(int id, User user, Language language, int power) {
        this.id = id;
        this.user = user;
        this.language = language;
        this.power = power;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" +
                "id=" + id +
                ", user=" + user +
                ", language=" + language +
                ", power=" + power +
                '}';
    }
}
