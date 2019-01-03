package players.fighters;

import players.fighters.weapons.IWeapon;;

public class Knight extends Fighter {

    private int armourValue;

    public Knight(String name, int healthValue, IWeapon weapon){
        super(name, healthValue, weapon);
        this.armourValue = 50;
    }

    public String battleCry(){
        return "For honour!!";
    }

    public void takeDamage(int value){
        if (armourValue > 0){
            value = value /2;
            this.armourValue -= 10;
        }
        super.takeDamage(value);
    }

}
