import components.ElectricMotor;
import components.Battery;
import org.junit.Before;
import org.junit.Test;
import vehicles.ElectricCar;

import static org.junit.Assert.assertEquals;

public class ElectricCarTest {

    ElectricCar electricCar;
    ElectricMotor electricMotor;
    Battery battery;


    @Before
    public void before(){
        battery = new Battery(50);
        electricMotor = new ElectricMotor(battery);
        electricCar = new ElectricCar(5, 10000, "Ruby", electricMotor);
    }

    @Test
    public void getPrice(){
        assertEquals(10000, electricCar.getPrice(), 0.01);
    }

    @Test
    public void getCapacity(){
        assertEquals(5, electricCar.getCapacity());
    }

    @Test
    public void getColour(){
        assertEquals("Ruby", electricCar.getColour());
    }

    @Test
    public void getBatteryRange(){
        assertEquals(50, electricCar.getRangeFromMotorBattery(), 0.01);
    }


}
