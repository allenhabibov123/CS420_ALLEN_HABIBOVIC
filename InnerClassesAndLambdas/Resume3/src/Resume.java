
/* TODO */
//Same two inner classes and member variables as in task 3.
/* TODO */
//Same initialization of Person and the List of Education objects
 /* TODO */
//Initialize the priority queue in one line, without importing the Comparator interface.
/* TODO */
//The getter for experience and the methods to add education and experience objects stay the same, as well as the toString()

/* TODO */

import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
//The imports will self populate. You don't have to do anything.

public class Resume {
    /* TODO */
//Copy the two inner classes of Resume exactly as they were in Task 2. Copy->paste.

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

    /* TODO */
//Create a member variable of type Person (exactly as in task 2)
    private Person person;
    private List<Education> educationList;
    private PriorityQueue<Experience> experiences;
    /* TODO */
//Create a List to hold values of type Education (exactly as in task 2)
    /* TODO */
//Create a Priority Queue that holds values of type Experience.
    public Resume(Person p){
        /* TODO */
//Assign a value to the Person variable.
        this.person = p;
        this.educationList = new ArrayList<>();
        this.experiences = new PriorityQueue<>((node1, node2) -> Integer.compare(node2.toYear, node1.toYear));
        /* TODO */
//Initialize the List with Education objects.
        /* TODO */
//Initialize the priority queue with a comparator defined in an anonymous inner class. Check the specs for the comparator.
    }

    public PriorityQueue<Experience> getExperience() {
        return this.experiences;
    }


    /* TODO */
//Add a standard getter for the experiences. getExperience. it should return a priority queue.

    /* TODO */
//Implement the addEducation, addExperience and override the toString() methods exactly as you did in task 2 (Copy->Paste)

    public void addExperience(Experience experience) {
        this.experiences.add(experience);
    }

    public void addEducation(Education education) {
        this.educationList.add(education);
    }

    public String toString() {
        String result = "";

        result += this.person.toString() + "\nExperience\n";
        for(Experience e: experiences){
            result += e.toString() + "\n";
        }
        result += "Education\n";
        for(Education e: educationList){
            result += e.toString() + "\n";
        }
        return result;
    }

}
