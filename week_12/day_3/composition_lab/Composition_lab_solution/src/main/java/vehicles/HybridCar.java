package vehicles;

import components.ElectricMotor;
import components.Engine;

public class HybridCar extends Vehicle {

    Engine engine;
    ElectricMotor electricMotor;

    public HybridCar(int capacity, double price, String colour, Engine engine, ElectricMotor electricMotor) {
        super(capacity, price, colour);
        this.engine = engine;
        this.electricMotor = electricMotor;
    }

    public Engine getEngine() {
        return engine;
    }

    public ElectricMotor getElectricMotor() {
        return electricMotor;
    }

    public int getRangeFromMotorBattery(){
        return electricMotor.getBatteryRange();
    }

    public double getEngineSize(){
        return engine.getSize();
    }

    public double getFuelTankCapacityFromEngine(){
        return engine.getFuelTankCapacity();
    }
}
