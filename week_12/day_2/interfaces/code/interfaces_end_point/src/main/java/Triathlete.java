public class Triathlete extends Athlete implements IRun, ISwim, ICycle {

    @Override
    public void run(int distance){
        distanceTravelled += distance;
    }

    @Override
    public void swim(int distance){
        distanceTravelled += distance;
    }

    @Override
    public void cycle(int distance){
        distanceTravelled += distance;
    }

}
