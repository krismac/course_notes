package rooms;

import enemies.Enemy;
import enemies.Orc;
import enemies.Troll;

import java.util.Random;

public class MonsterRoom extends Room {

    private Enemy enemy;

    public MonsterRoom() {
        randomEnemy();
        setCanExit(false);
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void randomEnemy() {
        int result = getRandomNumber(2);
        if (result == 0) {
            this.enemy = new Troll(100);
        } else if (result == 1) {
            this.enemy = new Orc(100);
        }
    }
}
