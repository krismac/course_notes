package components;

public class ElectricMotor {

    Battery battery;

    public ElectricMotor(Battery battery) {
        this.battery = battery;
    }

    public int getBatteryRange(){
        return battery.getRange();
    }
}
