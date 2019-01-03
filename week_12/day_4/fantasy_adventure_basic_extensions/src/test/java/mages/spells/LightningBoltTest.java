package mages.spells;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;
import players.magicusers.spells.FireBall;
import players.magicusers.spells.LightningBolt;

import static org.junit.Assert.assertEquals;

public class LightningBoltTest {
    LightningBolt bolt;
    Enemy troll;

    @Before
    public void before(){
        bolt = new LightningBolt();
        troll = new Troll(100);
    }

    @Test
    public void canCast(){
        bolt.cast(troll);
        assertEquals(60, troll.getHealthValue());
    }

}
