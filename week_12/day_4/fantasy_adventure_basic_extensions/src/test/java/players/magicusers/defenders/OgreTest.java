package players.magicusers.defenders;

import enemies.Orc;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OgreTest {

    Ogre ogre;
    Orc orc;

    @Before
    public void before(){
        ogre = new Ogre();
        orc = new Orc(100);
    }

    @Test
    public void canDefend(){
        ogre.defend(orc);
        assertEquals(60, orc.getHealthValue());
    }
}
