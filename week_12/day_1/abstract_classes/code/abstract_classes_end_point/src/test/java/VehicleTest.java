import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VehicleTest {
    Vehicle vehicle;

//    @Before
//    public void before() {
//        vehicle = new Vehicle("Ford Escort", 4);
//    }
//
//    @Test
//    public void vehicleHasNumberOfWheels() {
//        assertEquals(4, vehicle.getNumberOfWheels());
//    }
//
//    @Test
//    public void vehicleHasModel() {
//        assertEquals("Ford Escort", vehicle.getModel());
//    }
//
//    @Test
//    public void hasDrivingInstructions() {
//        assertEquals("Turn the key to start.", vehicle.drivingInstructions());
//    }

    //BELOW: Inheritance related tests:

    @Test
    public void carAsVehicle() {
        vehicle = new Car("Audi A8", 2);
        assertEquals("Audi A8", vehicle.getModel());
    }

    @Test
    public void motorbikeAsVehicle() {
        vehicle = new Motorbike("Harley");
        assertEquals("Harley", vehicle.getModel());
    }

    @Test
    public void changeTypeOfVehicle() {
        vehicle = new Car("Audi A8", 2);
        vehicle = new Motorbike("Harley");
        assertEquals("Harley", vehicle.getModel());
    }

    @Test
    public void collectionOfParentClassObjects() {
        ArrayList<Vehicle> garage = new ArrayList<>();
        garage.add( new Car("Audi A8", 2));
        garage.add( new Motorbike("Harley"));
//        garage.add( new Vehicle("Mini Morris", 4)); this won't work with abstract classes
        assertEquals(2, garage.size());
    }

    @Test
    public void objectRemembersItsType() {
        vehicle = new Car("Audi A8", 2);
        Car car  = (Car) vehicle; // Example of type casting Vehicle to Car
        assertEquals(2, car.getNumberOfDoors());
    }
}
