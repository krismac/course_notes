import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BearTest {

    Bear bear;
    Salmon salmon;
    River river;

    @Before
    public void before(){
        bear = new Bear("Baloo");
        salmon = new Salmon();
        river = new River();
        river.addFish(salmon);
    }

    @Test
    public void bellyStartsEmpty(){
        assertEquals(0, bear.foodCount());
    }

    @Test
    public void canEatSalmon(){
        bear.eatFishFromRiver(river); //AMENDED
        assertEquals(1, bear.foodCount());
        assertEquals(0, river.fishCount());
    }


    @Test
    public void shouldEmptyBellyAfterSleeping(){
        bear.eatFishFromRiver(river); //AMENDED
        assertEquals(bear.foodCount(), 1);
        bear.sleep();
        assertEquals(bear.foodCount(), 0);
    }
}
