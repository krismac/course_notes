import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterBottleTest {

    WaterBottle waterBottle;

    @Before
    public void setUp() {
        waterBottle = new WaterBottle();
    }

    @Test
    public void hasVolumeStart100() {
        assertEquals(100, waterBottle.getVolume());
    }

    @Test
    public void canDrink(){
        waterBottle.drink();
        assertEquals(90, waterBottle.getVolume());
    }

    @Test
    public void canEmpty(){
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
    }

    @Test
    public void canFill(){
        waterBottle.empty();
        assertEquals(0, waterBottle.getVolume());
        waterBottle.refill();
        assertEquals(100, waterBottle.getVolume());
    }
}
