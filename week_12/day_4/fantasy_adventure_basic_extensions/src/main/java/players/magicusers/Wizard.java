package players.magicusers;

import players.magicusers.defenders.IDefend;
import players.magicusers.spells.ISpell;

public class Wizard extends Mage {


    public Wizard(String name, int healthValue, ISpell spell, IDefend defender){
        super(name, healthValue, spell, defender);
    }


}
