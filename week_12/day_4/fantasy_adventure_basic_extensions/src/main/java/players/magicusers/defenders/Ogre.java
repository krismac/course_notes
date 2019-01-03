package players.magicusers.defenders;

import enemies.Enemy;

public class Ogre implements IDefend {

    private int damageValue;

    public Ogre(){
        this.damageValue = 40;
    }

    public void defend(Enemy enemy){
        enemy.takeDamage(this.damageValue);
    }
}
