package medics;

import fighters.weapons.Sword;
import healer.Herb;
import healer.Potion;
import org.junit.Before;
import org.junit.Test;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class PotionTest {

    Potion potion;
    Sword sword;
    Knight knight;

    @Before
    public void before(){
        potion = new Potion();
        sword = new Sword();
        knight = new Knight("Lord Downey", 50, sword );
    }

    @Test
    public void canHeal(){
        potion.heal(knight);
        assertEquals(70, knight.getHealthValue());
    }
}
