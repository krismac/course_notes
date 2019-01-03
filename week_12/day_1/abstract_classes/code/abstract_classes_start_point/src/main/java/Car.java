public class Car extends Vehicle {

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

    public String openDoors()
    {
        return ("Beep. "+ numberOfDoors +" doors opened.");
    }


    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}
