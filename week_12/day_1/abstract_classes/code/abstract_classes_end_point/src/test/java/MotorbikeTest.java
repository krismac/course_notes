import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MotorbikeTest {
    Motorbike motorbike;

    @Before
    public void before() {
        motorbike = new Motorbike("Vespa 150");
    }

    @Test
    public void motorbikeHasNumberOfWheels() {
        assertEquals(2, motorbike.getNumberOfWheels());
    }

    @Test
    public void canStartEngine() {
        assertEquals("Vrrr. Engine is running.", motorbike.startEngine());
    }

    @Test
    public void hasBoardingInstructions() {
        assertEquals("Just hop on.", motorbike.boardingInstructions());
    }

    @Test
    public void hasDrivingInstructions() {
        assertEquals("Turn the key to start. Use handlebars to steer.", motorbike.drivingInstructions());
    }

    @Test
    public void canBeReplacedMotorbikeByCar() {
        Vehicle myVehicle = new Motorbike("Vespa");
        myVehicle = new Car("Audi", 4);
        assertEquals("Vrrr. Engine is running.", myVehicle.startEngine());
    }


}
