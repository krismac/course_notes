package players;

import enemies.Enemy;
import fighters.weapons.IWeapon;

public abstract class Player {

    private String name;
    private int healthValue;

    public Player(String name, int healthValue){
        this.name = name;
        this.healthValue = healthValue;
    }

    public String getName() {
        return name;
    }

    public int getHealthValue() {
        return healthValue;
    }


    public void takeDamage(int damage){
        this.healthValue -= damage;
    }

    public void attack(Enemy enemy, IWeapon weapon){
        weapon.attack(enemy);
    }

    public void getHealth(int value){
        this.healthValue += value;
    }


}
