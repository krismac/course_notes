package mages.spells;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;
import players.magicusers.spells.FireBall;

import static org.junit.Assert.assertEquals;

public class FireBallTest {

    FireBall fball;
    Enemy troll;

    @Before
    public void before(){
        fball = new FireBall();
        troll = new Troll(100);
    }

    @Test
    public void canCast(){
        fball.cast(troll);
        assertEquals(30, troll.getHealthValue());
    }
}
