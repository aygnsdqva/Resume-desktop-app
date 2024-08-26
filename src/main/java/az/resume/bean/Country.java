package az.resume.bean;

public class Country {
    private  int id;
    private String countryName;
    private String nationalityIso;

    public Country() {
    }

    public Country(int id, String countryName, String nationalityIso) {
        this.id = id;
        this.countryName = countryName;
        this.nationalityIso = nationalityIso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getNationalityIso() {
        return nationalityIso;
    }

    public void setNationalityIso(String nationalityIso) {
        this.nationalityIso = nationalityIso;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + countryName + '\'' +
                ", nationalityIso='" + nationalityIso + '\'' +
                '}';
    }
}
