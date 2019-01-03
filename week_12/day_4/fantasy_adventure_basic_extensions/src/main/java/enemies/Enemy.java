package enemies;

public abstract class Enemy {

    private int healthValue;

    public Enemy(int healthValue){
        this.healthValue = healthValue;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public void takeDamage(int value){
        this.healthValue -= value;
    }
}
