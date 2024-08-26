package az.resume.bean;

import java.util.List;

public class User {
    private  int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String about;
    private Country country;
    private List<Certificate> certificates;
    private List<Experience> experiences;
    private List<Hobby> hobbies;

    private List<UserEducation> educations;
    private List<UserLanguage> languages;
    private List<UserSkill> skills;

    public User() {
    }

    public User(int id, String name, String surname, String email, String phone, String about, Country country, List<Certificate> certificates, List<Experience> experiences, List<Hobby> hobbies, List<UserEducation> educations, List<UserLanguage> languages, List<UserSkill> skills) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.about = about;
        this.country = country;
        this.certificates = certificates;
        this.experiences = experiences;
        this.hobbies = hobbies;
        this.educations = educations;
        this.languages = languages;
        this.skills = skills;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public List<UserEducation> getEducations() {
        return educations;
    }

    public void setEducations(List<UserEducation> educations) {
        this.educations = educations;
    }

    public List<UserLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<UserLanguage> languages) {
        this.languages = languages;
    }

    public List<UserSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<UserSkill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", about='" + about + '\'' +
                ", country=" + country +
                ", certificates=" + certificates +
                ", experiences=" + experiences +
                ", hobbies=" + hobbies +
                ", educations=" + educations +
                ", languages=" + languages +
                ", skills=" + skills +
                '}';
    }
}
