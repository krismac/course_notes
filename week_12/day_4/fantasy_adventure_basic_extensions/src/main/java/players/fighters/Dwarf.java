package players.fighters;

import players.fighters.weapons.IWeapon;

import java.util.Random;

public class Dwarf extends Fighter {

    private int gems;

    public Dwarf(String name, int healthValue, IWeapon weapon){
        super(name, healthValue, weapon);
        this.gems = 0;
    }

    public int getGems() {
        return gems;
    }

    public String battleCry(){
        return "Baruk Khazâd! Khazâd ai-mênu!";
    }

    public void mineForGems(){
        Random rand = new Random();
        int numberOfGems =  rand.nextInt(6);
        this.gems += numberOfGems;
    }

}
