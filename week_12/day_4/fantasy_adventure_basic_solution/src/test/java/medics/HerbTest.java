package medics;

import fighters.weapons.Sword;
import healer.Herb;
import org.junit.Before;
import org.junit.Test;
import players.fighters.Dwarf;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class HerbTest {

    Herb herb;
    Sword sword;
    Knight knight;

    @Before
    public void before(){
        herb = new Herb();
        sword = new Sword();
        knight = new Knight("Lord Rust", 50, sword );
    }

    @Test
    public void canHeal(){
        herb.heal(knight);
        assertEquals(60, knight.getHealthValue());
    }
}
