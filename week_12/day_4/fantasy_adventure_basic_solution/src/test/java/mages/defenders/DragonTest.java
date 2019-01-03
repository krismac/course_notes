package mages.defenders;

import enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DragonTest {

    Dragon dragon;
    Troll troll;

    @Before
    public void before(){
        dragon = new Dragon();
        troll = new Troll(100);
    }

    @Test
    public void canDefend(){
        dragon.defend(troll);
        assertEquals(40, troll.getHealthValue());
    }
}
