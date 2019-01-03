package fighters;

import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;
import fighters.weapons.Axe;
import fighters.weapons.Club;
import fighters.weapons.IWeapon;
import players.fighters.Dwarf;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    Dwarf dwarf;
    Enemy enemy;
    IWeapon axe;
    IWeapon club;

    @Before
    public void before(){
        axe = new Axe();
        club = new Club();
        enemy = new Troll(100);
        dwarf = new Dwarf("Grabthroat Shinkicker", 100, axe);
    }

    @Test
    public void hasName(){
        assertEquals("Grabthroat Shinkicker", dwarf.getName());
    }

    @Test
    public void hasHealthValue(){
        assertEquals(100, dwarf.getHealthValue());
    }

    @Test
    public void hasBattleCry(){
        assertEquals("Baruk Khazâd! Khazâd ai-mênu!", dwarf.battleCry());
    }

    @Test
    public void canTakeDamage(){
        dwarf.takeDamage(50);
        assertEquals(50, dwarf.getHealthValue());
    }

    @Test
    public void canSwapWeapon(){
        dwarf.setWeapon(club);
        dwarf.attack(enemy);
        assertEquals(90, enemy.getHealthValue());
    }

    @Test
    public void canAttack(){
        dwarf.attack(enemy);
        assertEquals(50, enemy.getHealthValue());
    }

    @Test
    public void canMine(){
        dwarf.mineForGems();
        assertEquals(true, dwarf.getGems() > 0);
    }
}
