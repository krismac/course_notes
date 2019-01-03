package fighters;

import enemies.Enemy;
import enemies.Orc;
import org.junit.Before;
import org.junit.Test;
import fighters.weapons.Club;
import fighters.weapons.IWeapon;
import fighters.weapons.Sword;
import players.fighters.Knight;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    Knight knight;
    Enemy enemy;
    IWeapon sword;
    IWeapon club;

    @Before
    public void before(){
        sword = new Sword();
        club = new Club();
        enemy = new Orc( 100);
        knight = new Knight("Sam Vimes", 100, sword);
    }

    @Test
    public void hasName(){
        assertEquals("Sam Vimes", knight.getName());
    }

    @Test
    public void hasHealthValue(){
        assertEquals(100, knight.getHealthValue());
    }

    @Test
    public void hasBattleCry(){
        assertEquals("For honour!!", knight.battleCry());
    }

    @Test
    public void canTakeDamageWithShield(){
        knight.takeDamage(20);
        assertEquals(90, knight.getHealthValue());
    }

    @Test
    public void canTakeDamageWithoutShield(){
        for (int i = 0; i < 6; i++){
            knight.takeDamage(20);
        }
        assertEquals(30, knight.getHealthValue());
    }

    @Test
    public void canSwapWeapon(){
        knight.setWeapon(club);
        knight.attack(enemy);
        assertEquals(90, enemy.getHealthValue());
    }

    @Test
    public void canAttack(){
        knight.attack(enemy);
        assertEquals(70, enemy.getHealthValue());
    }
}
