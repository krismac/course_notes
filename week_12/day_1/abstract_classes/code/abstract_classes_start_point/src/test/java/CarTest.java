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
    public void canOpenDoors() {
        assertEquals("Beep. 4 doors opened.", car.openDoors());
    }

    @Test
    public void hasDrivingInstructions() {
        assertEquals("Turn the key to start. Use steering wheel to steer.", car.drivingInstructions());
    }

    @Test
    public void canStartEngine() {
        assertEquals("Vrrr. Engine is running.", car.startEngine());
    }

}
