package vehicles;

import components.ElectricMotor;

public class ElectricCar extends Vehicle {
    ElectricMotor electricMotor;

    public ElectricCar(int capacity, double price, String colour, ElectricMotor electricMotor) {
        super(capacity, price, colour);
        this.electricMotor = electricMotor;
    }

    public ElectricMotor getElectricMotor() {
        return electricMotor;
    }

    public int getRangeFromMotorBattery(){
        return electricMotor.getBatteryRange();
    }
}
