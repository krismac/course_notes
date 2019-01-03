package players.magicusers.defenders;

import enemies.Enemy;

public class Dragon implements IDefend {

    private int damageValue;

    public Dragon(){
        this.damageValue = 60;
    }

    public void defend(Enemy enemy){
        enemy.takeDamage(this.damageValue);
    }
}
