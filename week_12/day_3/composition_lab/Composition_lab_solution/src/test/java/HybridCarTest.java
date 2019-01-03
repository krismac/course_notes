import components.Battery;
import components.ElectricMotor;
import components.FuelTank;
import components.Engine;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.HybridCar;

import static org.junit.Assert.assertEquals;

public class HybridCarTest {

    Battery battery;
    ElectricMotor electricMotor;
    FuelTank fuelTank;
    Engine engine;
    private HybridCar hybrid;

    @Before
    public void before(){
        battery = new Battery(50);
        electricMotor = new ElectricMotor(battery);
        fuelTank = new FuelTank(100);
        engine = new Engine(1.0, fuelTank);
        hybrid = new HybridCar(4, 20000, "BlueSteel", engine, electricMotor);
    }

    @Test
    public void getPrice(){
        assertEquals(20000, hybrid.getPrice(), 0.01);
    }

    @Test
    public void getCapacity(){
        assertEquals(4, hybrid.getCapacity());
    }

    @Test
    public void getColour(){
        assertEquals("BlueSteel", hybrid.getColour());
    }

    @Test
    public void getBatteryRange(){
        assertEquals(50, hybrid.getRangeFromMotorBattery(), 0.01);
    }

    @Test
    public void getEngineSize(){
        assertEquals(1.0, hybrid.getEngineSize(), 0.01);
    }

    @Test
    public void canGetFuelTankCapacity() {
        assertEquals(100, hybrid.getFuelTankCapacityFromEngine(), 0.01);
    }


}
