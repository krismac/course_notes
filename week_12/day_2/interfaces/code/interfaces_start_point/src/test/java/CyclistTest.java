import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CyclistTest {

    Cyclist cyclist;

    @Before
    public void before() {
        cyclist = new Cyclist();
    }

    @Test
    public void hasDistanceAtBeginning() {
        assertEquals(0, cyclist.getDistanceTravelled());
    }

}
