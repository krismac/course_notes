package healer;

import players.Player;

public class Potion implements IHeal {

    private int healingValue;


    public Potion(){
        this.healingValue = 20;
    }

    public void heal(Player player){
        player.getHealth(this.healingValue);
    }
}
