package vehicles;
import components.Engine;



public class Car extends Vehicle {

    Engine engine;

    public Car(int capacity, double price, String colour, Engine engine) {
        super(capacity, price, colour);
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }

    public double getEngineSize(){
        return engine.getSize();
    }

    public double getFuelTankCapacityFromEngine(){
        return engine.getFuelTankCapacity();
    }
}
