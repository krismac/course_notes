package players.fighters.weapons;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwordTest {

    Enemy enemy;
    Sword sword;

    @Before
    public void before(){
        sword = new Sword();
        enemy = new Troll(100);
    }

    @Test
    public void canDamage(){
        sword.attack(enemy);
        assertEquals(70, enemy.getHealthValue());
    }
}
