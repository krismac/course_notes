package fighters.weapons;

import enemies.Enemy;

public class Club implements IWeapon {

    public void attack(Enemy enemy){
        enemy.takeDamage(10);
    }
}
