package players.magicusers.spells;

import enemies.Enemy;

public class LightningBolt implements ISpell {

    private int damageValue;


    public LightningBolt(){
        this.damageValue = 40;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void cast(Enemy enemy){
        enemy.takeDamage(damageValue);
    }

}
