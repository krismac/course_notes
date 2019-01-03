public class Swimmer extends Athlete implements ISwim {

    public void swim(int distance){
        distanceTravelled += distance;
    }
}
