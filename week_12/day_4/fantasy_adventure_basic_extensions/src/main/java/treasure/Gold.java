package treasure;

import java.util.Random;

public class Gold implements ITreasure {

    public int amount;

    public Gold(){
        this.amount = 100;
    }

    @Override
    public int getValue() {
        return amount;
    }

}
