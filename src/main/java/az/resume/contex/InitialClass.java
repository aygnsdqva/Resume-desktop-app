package az.resume.contex;
import az.resume.dao.*;
import az.resume.dao.impl.*;

public class InitialClass {

    public static void initialCertificateDAO(){
        CertificateDAO certificateDAO = new CertificateDAOImpl();
    }
    public static void initialCountryDAO(){
        CountryDAO countryDAO = new CountryDAOImpl();
    }
    public static void initialDegreeDAO(){
        DegreeDAO degreeDAO = new DegreeDAOImpl();
    }
    public static void initialExperienceDAO(){
        ExperienceDAO experienceDAO = new ExperienceDAOImpl();
    }
    public static void initialHobbyDAO(){
        HobbyDAO hobbyDAO = new HobbyDAOImpl();
    }
    public static void initialLanguageDAO(){
        LanguageDAO languageDAO = new LanguageDAOImpl();
    }
    public static void initialProfessionDAO(){
        ProfessionDAO professionDAO = new ProfessionDAOImpl();
    }
    public static void initialSkillDAO(){
        SkillDAO skillDAO = new SkillDAOImpl();
    }
    public static void initialUniversityDAO(){
        UniversityDAO universityDAO = new UniversityDAOImpl();
    }
}
