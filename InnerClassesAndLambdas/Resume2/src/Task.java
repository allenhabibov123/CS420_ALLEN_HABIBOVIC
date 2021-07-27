
/* TODO */
//Copy the Task from task 2 here and add experiences where the end years are not in order. Watch it print the resume with the dates in order from most recent to least.

public class Task {
    public static void main(String[] args){
        Person p = new Person("Kim Possible","2000-01-01");
        p.setPosition("Associate", 34000);
        Resume r = new Resume(p);
        /* TODO */
//Create an education object. Schoo is NEIU, major is Computer Science.
        Resume.Education e = r.new Education("NEIU", "Computer Science");
        /* TODO */
//add this education object to the resume "r"
        r.addEducation(e);
        /* TODO */
//Create a new Experience object and add it to the resume.
        Resume.Experience ex = new Resume.Experience("Barista", 2017, 2018);
        r.addExperience(ex);/* TODO */
//Create a new experience object on the fly, inside the addExperiece call.);
        r.addExperience(new Resume.Experience("Driver", 2012, 2019));/* TODO */
//Add another experience object on the fly as you add it.);
        r.addExperience(new Resume.Experience("Mover", 2015, 2020));
        System.out.println(r); //watch the resume print.

    }
}