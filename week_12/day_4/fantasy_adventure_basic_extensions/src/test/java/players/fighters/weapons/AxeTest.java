package players.fighters.weapons;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AxeTest {

    Enemy enemy;
    Axe axe;

    @Before
    public void before(){
        axe = new Axe();
        enemy = new Troll(100);
    }

    @Test
    public void canDamage(){
        axe.attack(enemy);
        assertEquals(50, enemy.getHealthValue());
    }
}
