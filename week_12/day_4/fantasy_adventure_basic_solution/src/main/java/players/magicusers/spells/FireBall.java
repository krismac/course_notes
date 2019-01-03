package players.magicusers.spells;

import enemies.Enemy;

public class FireBall implements ISpell {

    private int damageValue;


    public FireBall(){
        this.damageValue = 70;
    }

    public int getDamageValue() {
        return damageValue;
    }

    public void cast(Enemy enemy){
        enemy.takeDamage(damageValue);
    }

}
