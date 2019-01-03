package rooms;

import treasure.Gold;
import treasure.ITreasure;
import treasure.Jewel;

public class TreasureRoom extends Room{

    ITreasure treasure;

    public TreasureRoom() {
        randomTreasure();
        setCanExit(false);
    }

    public ITreasure getTreasure() {
        return treasure;
    }

    public void randomTreasure() {
        int result = getRandomNumber(1);
        if (result == 0) {
            this.treasure = new Gold();
        } else {
            this.treasure = new Jewel();
        }
    }

}
