import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwimmerTest {

    Swimmer swimmer;

    @Before
    public void before() {
        swimmer = new Swimmer();
    }

    @Test
    public void hasDistanceAtBeginning() {
        assertEquals(0, swimmer.getDistanceTravelled());
    }

    @Test
    public void canSwim() {
        swimmer.swim(10);
        assertEquals(10, swimmer.getDistanceTravelled());
    }





}
