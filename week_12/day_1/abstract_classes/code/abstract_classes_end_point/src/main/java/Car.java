import com.sun.org.apache.xpath.internal.operations.Bool;

public class Car extends Vehicle{

    private int numberOfDoors;

    public Car(String model, int numberOfDoors)
    {
        super(model, 4);
        this.numberOfDoors = numberOfDoors;
    }

    public String drivingInstructions()
    {
        return super.drivingInstructions() + " Use steering wheel to steer.";

    }

    public String boardingInstructions(){
        return "Enter via one of the " + numberOfDoors + " doors.";
    }


    public String openDoors()
    {
        return ("Beep. "+ numberOfDoors +" doors opened.");
    }


    public int getNumberOfDoors() {
        return numberOfDoors;
    }

}
