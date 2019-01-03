package players.fighters;

import enemies.Enemy;
import players.Player;
import fighters.weapons.IWeapon;

public abstract class Fighter extends Player {

    private IWeapon weapon;

    public Fighter(String name, int healthValue, IWeapon weapon){
        super(name, healthValue);
        this.weapon = weapon;
    }

    public void setWeapon(IWeapon weapon){
        this.weapon = weapon;
    }

    public void attack(Enemy enemy){
        this.weapon.attack(enemy);
    }

}
