import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarTest {
    Car car;

    @Before
    public void before() {
        car = new Car("Ford Escort", 4);
    }

    @Test
    public void carHasNumberOfWheels() {
        assertEquals(4, car.getNumberOfWheels());
    }

    @Test
    public void carHasModel() {
        assertEquals("Ford Escort", car.getModel());
    }

    @Test
    public void carHasNumberOfDoors() {
        assertEquals(4, car.getNumberOfDoors());
    }

    @Test
    public void hasDrivingInstructions() {
        assertEquals("Turn the key to start. Use steering wheel to steer.", car.drivingInstructions());
    }

    @Test
    public void canOpenDoors() {
        assertEquals("Beep. 4 doors opened.", car.openDoors());
    }

    @Test
    public void canStartEngine() {
        assertEquals("Vrrr. Engine is running.", car.startEngine());
    }

    @Test
    public void hasBoardingInstructions() {
        assertEquals("Enter via one of the 4 doors.", car.boardingInstructions());
    }

    @Test
    public void canBeReplacedCarByMotorbike() {
        Vehicle myVehicle = new Car("Audi", 4);
         myVehicle = new Motorbike("Vespa");
        assertEquals("Vrrr. Engine is running.", myVehicle.startEngine());
    }

}
