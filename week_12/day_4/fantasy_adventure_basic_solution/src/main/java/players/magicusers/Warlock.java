package players.magicusers;

import mages.defenders.IDefend;
import players.magicusers.spells.ISpell;

public class Warlock extends Mage {


    public Warlock(String name, int healthValue, ISpell spell, IDefend defender) {
        super(name, healthValue, spell, defender);
    }

}
