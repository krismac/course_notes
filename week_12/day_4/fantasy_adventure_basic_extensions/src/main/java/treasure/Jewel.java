package treasure;

import java.util.Random;

public class Jewel implements ITreasure{
    public int amount;

    public Jewel(){
        this.amount = 250;
    }

    @Override
    public int getValue() {
        return amount;
    }

}
