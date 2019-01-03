package players.medic;

import healer.IHeal;
import players.Player;

public class Cleric extends Player{

    private IHeal medicine;

    public Cleric(String name, int healthValue, IHeal medicine ){
        super(name, healthValue);
        this.medicine = medicine;
    }

    public void setMedicine(IHeal medicine) {
        this.medicine = medicine;
    }

    public void heal(Player player){
        this.medicine.heal(player);
    }
}
