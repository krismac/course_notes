package fighters.weapons;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClubTest {

    Enemy enemy;
    Club club;

    @Before
    public void before(){
        club = new Club();
        enemy = new Troll(100);
    }

    @Test
    public void canDamage(){
        club.attack(enemy);
        assertEquals(90, enemy.getHealthValue());
    }
}
