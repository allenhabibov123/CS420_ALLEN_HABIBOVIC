import java.util.ArrayList;
import java.util.List;

public class Resume {
/* TODO */
//Create a public member inner class Education according to the specifications.
    public class Education {
        String school;
        String major;

        public void setSchool(String school) {
            this.school = school;
        }

        public String getSchool() {
            return this.school;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        public String getMajor() {
            return this.major;
        }

        public Education(String school, String major) {
            this.setSchool(school);
            this.setMajor(major);
        }
        public String toString() {
            return this.getMajor() + " at " + this.getSchool();
        }
    }

    public static class Experience {
        String title;
        int fromYear;
        int toYear;

        public Experience(String title, int fromYear, int toYear) {
            this.title = title;
            this.fromYear = fromYear;
            this.toYear = toYear;
        }


        public String toString() {
            return fromYear + "-" + toYear + ": " + title;
        }

    }

    private Person person;
    private List<Education> educationList;
    private List<Experience> experienceList;

    public Resume(Person person) {
        this.person = person;
        this.educationList = new ArrayList<>();
        this.experienceList = new ArrayList<>();
    }

    public void addExperience(Experience experience) {
        this.experienceList.add(experience);
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public String toString() {
        String result = "";

        result += this.person.toString() + "\nExperience\n";
        for(Experience e: experienceList){
            result += e.toString() + "\n";
        }
        result += "Education\n";
        for(Education e: educationList){
            result += e.toString() + "\n";
        }
        return result;
    }

/* TODO */
//Create a public static inner class called Experience, according to the specifications.

/* TODO */
//Create the Person and List of Education and List of experience objects. They should be private.

/* TODO */
//This constructor should initialize the person and do all necessary initializations for the other methods to work.


/* TODO */
//Create the addEducation, addExperience and override the toString methods as specified.

}
