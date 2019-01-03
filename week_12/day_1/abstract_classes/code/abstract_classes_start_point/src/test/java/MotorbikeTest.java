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
    public void hasDrivingInstructions() {
        assertEquals("Turn the key to start. Use handlebars to steer.", motorbike.drivingInstructions());
    }

    @Test
    public void canStartEngine() {
        assertEquals("Vrrr. Engine is running.", motorbike.startEngine());
    }

}