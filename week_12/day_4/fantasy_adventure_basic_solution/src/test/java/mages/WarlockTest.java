package mages;

import mages.defenders.Dragon;
import mages.defenders.Ogre;
import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;
import players.magicusers.Warlock;
import players.magicusers.spells.FireBall;
import players.magicusers.spells.LightningBolt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WarlockTest {

    FireBall fireball;
    LightningBolt bolt;
    Warlock warlock;
    Enemy troll;
    Dragon dragon;
    Ogre ogre;

    @Before
    public void before(){
        dragon = new Dragon();
        ogre = new Ogre();
        fireball = new FireBall();
        bolt = new LightningBolt();
        troll = new Troll(100);
        warlock = new Warlock("Geoffrey Swivel", 100, fireball, dragon);
    }

    @Test
    public void hasName(){
        assertEquals("Geoffrey Swivel", warlock.getName());
    }

    @Test
    public void hasHealthValue(){
        assertEquals(100, warlock.getHealthValue());
    }

    @Test
    public void canCastSpell(){
        warlock.cast(troll);
        assertEquals(30, troll.getHealthValue());
    }

    @Test
    public void canChangeSpell(){
        warlock.setSpell(bolt);
        warlock.cast(troll);
        assertEquals(60, troll.getHealthValue());
    }

    @Test
    public void canDefend(){
        warlock.defend(troll);
        assertEquals(40, troll.getHealthValue());
    }

    @Test
    public void canChangeDefender(){
        warlock.setDefender(ogre);
        warlock.defend(troll);
        assertEquals(60, troll.getHealthValue());
    }


}
