import java.util.ArrayList;

        /* TODO */
        //Implement the class Adult Patient.
        //An adult patient is a Person that is Diagnosable and that is Employable.

public class AdultPatient extends Person implements Diagnosable, Employable{
    double temperature;
    int systolic;
    int diastolic;
    ArrayList<String> jobs;

    @Override
    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public int getSystolic() {
        return this.systolic;
    }

    @Override
    public int getDiastolic() {
        return this.diastolic;
    }

    @Override
    public void setTemperature(double t) {
        this.temperature = t;
    }

    @Override
    public void setSystolic(int s) {
        this.systolic = s;
    }

    @Override
    public void setDiastolic(int d) {
        this.diastolic = d;
    }

    @Override
    public ArrayList<String> getPreviousJobs() {
        return this.jobs;
    }

    @Override
    public void addJob(String j) {
        if(this.jobs == null) {
            this.jobs = new ArrayList<String>();
        }
        this.jobs.add(j);
    }

}