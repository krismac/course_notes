package medics;

import healer.Herb;
import healer.Potion;
import org.junit.Before;
import org.junit.Test;
import players.fighters.Dwarf;
import players.medic.Cleric;
import players.fighters.weapons.IWeapon;
import players.fighters.weapons.Sword;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Dwarf dwarf;
    IWeapon sword;
    Cleric cleric;
    Potion potion;
    Herb herb;

    @Before
    public void before(){
        sword = new Sword();
        potion = new Potion();
        herb = new Herb();
        dwarf = new Dwarf("Ringfounder", 80, sword);
        cleric = new Cleric("Dr Lawn", 100, potion);
    }

    @Test
    public void hasName(){
        assertEquals("Dr Lawn", cleric.getName());
    }

    @Test
    public void hasHealth(){
        assertEquals(100, cleric.getHealthValue());
    }

    @Test
    public void canHeal(){
        cleric.heal(dwarf);
        assertEquals(100, dwarf.getHealthValue());
    }

    @Test
    public void canChangeMedicine(){
        cleric.setMedicine(herb);
        cleric.heal(dwarf);
        assertEquals(90, dwarf.getHealthValue());
    }

}
