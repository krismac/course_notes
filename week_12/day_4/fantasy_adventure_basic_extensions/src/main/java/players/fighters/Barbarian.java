package players.fighters;

import players.fighters.weapons.IWeapon;

public class Barbarian extends Fighter {

    private int speed;

    public Barbarian(String name, int healthValue, IWeapon weapon, int speed){
        super(name, healthValue, weapon);
        this.speed = speed;
    }

    public String battleCry(){
        return "a sword-day, a red day, ere the sun rises";
    }

    public int getSpeed() {
        return speed;
    }


}
