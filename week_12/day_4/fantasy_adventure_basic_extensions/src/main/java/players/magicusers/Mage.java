package players.magicusers;

import players.magicusers.defenders.IDefend;
import enemies.Enemy;
import players.Player;
import players.magicusers.spells.ISpell;

public class Mage extends Player {

    private ISpell spell;
    private IDefend defender;

    public Mage(String name, int healthValue, ISpell spell, IDefend defender){
        super(name, healthValue);
        this.spell = spell;
        this.defender = defender;
    }

    public void setSpell(ISpell spell){
        this.spell = spell;
    }

    public void setDefender(IDefend defender) {
        this.defender = defender;
    }

    public void defend(Enemy enemy){
        this.defender.defend(enemy);
    }

    public void cast(Enemy enemy){
        this.spell.cast(enemy);
    }

}
