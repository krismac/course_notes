package rooms;

import java.util.ArrayList;

import java.util.Random;

public abstract class Room {


    private boolean canExit;

    public Room() {
        this.canExit = true;

    }


    public void setCanExit(boolean canExit) {
        this.canExit = canExit;
    }

    public boolean canExit() {
        return canExit;
    }


    public int getRandomNumber(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}

