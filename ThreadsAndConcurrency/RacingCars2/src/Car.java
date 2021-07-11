public class Car {
    public double miles;
    public double odometer;
    public String name;
    public double maxMiles;

 /* TODO 
Exact same methods and constructor as the Car in task 1*/
 public Car(String name,double miles){
     this.miles = miles;
     odometer = 0;
     this.name = name;
     this.maxMiles = miles;
 }

    public void move(double miles){
        /* TODO
move should subtract  'miles' from the miles left to travel and add 'miles' to the odometer. The miles to travel cannot be less than zero. */
        if(this.miles > 0) {
            this.miles -= miles;
            this.odometer += miles;
        }
    }

    public void charge(){
        this.miles = maxMiles;
    }

    public String toString(){
        return name+": odo:"+odometer+" - miles left:"+miles;
    }
}
