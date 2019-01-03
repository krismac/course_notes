package components;

public class Engine {

    FuelTank fuelTank;
    private double size;


    public Engine(double size, FuelTank fuelTank) {
        this.fuelTank = fuelTank;
        this.size = size;
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public double getSize() {
        return size;
    }

    public double getFuelTankCapacity(){
        return this.fuelTank.getTankCapacity();
    }
}
