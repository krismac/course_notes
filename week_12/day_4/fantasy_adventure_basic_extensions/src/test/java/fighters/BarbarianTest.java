package fighters;

import enemies.Enemy;
import enemies.Orc;
import org.junit.Before;
import org.junit.Test;
import players.fighters.weapons.Club;
import players.fighters.weapons.IWeapon;
import players.fighters.weapons.Sword;
import players.fighters.Barbarian;

import static org.junit.Assert.assertEquals;

public class BarbarianTest {

    Barbarian barbarian;
    Enemy enemy;
    IWeapon club;
    IWeapon sword;

    @Before
    public void before(){
        club = new Club();
        sword = new Sword();
        barbarian = new Barbarian("Cohen", 100, club, 20 );
        enemy = new Orc(100);
    }

    @Test
    public void hasName(){
        assertEquals("Cohen", barbarian.getName());
    }

    @Test
    public void hasHealthValue(){
        assertEquals(100, barbarian.getHealthValue());
    }

    @Test
    public void hasSpeed(){
        assertEquals(20, barbarian.getSpeed());
    }

    @Test
    public void hasBattleCry(){
        assertEquals("a sword-day, a red day, ere the sun rises", barbarian.battleCry());
    }

    @Test
    public void canSwapWeapon(){
        barbarian.setWeapon(sword);
        barbarian.attack(enemy);
        assertEquals(70, enemy.getHealthValue());
    }

    @Test
    public void canTakeDamage(){
        barbarian.takeDamage(20);
        assertEquals(80, barbarian.getHealthValue());
    }

    @Test
    public void canAttack(){
        barbarian.attack(enemy);
        assertEquals(90, enemy.getHealthValue());
    }
}
