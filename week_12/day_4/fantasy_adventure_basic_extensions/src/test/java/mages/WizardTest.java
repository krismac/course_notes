package mages;

import players.magicusers.defenders.Dragon;
import players.magicusers.defenders.Ogre;
import enemies.Enemy;
import enemies.Troll;
import org.junit.Before;
import org.junit.Test;
import players.magicusers.Wizard;
import players.magicusers.spells.FireBall;
import players.magicusers.spells.LightningBolt;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    FireBall fireball;
    LightningBolt bolt;
    Wizard wizard;
    Enemy troll;
    Dragon dragon;
    Ogre ogre;

    @Before
    public void before(){
        dragon = new Dragon();
        ogre = new Ogre();
        fireball = new FireBall();
        bolt = new LightningBolt();
        troll = new Troll(100);
        wizard = new Wizard("RinceWind", 100, bolt, ogre);
    }

    @Test
    public void hasName(){
        assertEquals("RinceWind", wizard.getName());
    }

    @Test
    public void hasHealthValue(){
        assertEquals(100, wizard.getHealthValue());
    }

    @Test
    public void canCastSpell(){
        wizard.cast(troll);
        assertEquals(60, troll.getHealthValue());
    }

    @Test
    public void canChangeSpell(){
        wizard.setSpell(fireball);
        wizard.cast(troll);
        assertEquals(30, troll.getHealthValue());
    }

    @Test
    public void canDefend(){
        wizard.defend(troll);
        assertEquals(60, troll.getHealthValue());
    }

    @Test
    public void canChangeDefender(){
        wizard.setDefender(dragon);
        wizard.defend(troll);
        assertEquals(40, troll.getHealthValue());
    }
}
