package players.fighters.weapons;

import enemies.Enemy;

public class Sword implements IWeapon {


    public void attack(Enemy enemy){
        enemy.takeDamage(30);
    }

}
