package healer;

import players.Player;

public class Herb implements IHeal {

    private int healingValue;


    public Herb(){
        this.healingValue = 10;
    }

    public void heal(Player player){
        player.getHealth(this.healingValue);
    }
}
