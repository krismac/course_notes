package players.fighters.weapons;
import enemies.Enemy;

public class Axe implements IWeapon {

    public void attack(Enemy enemy){
        enemy.takeDamage(50);
    }
}
