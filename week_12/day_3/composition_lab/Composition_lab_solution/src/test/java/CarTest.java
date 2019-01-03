import components.FuelTank;
import components.Engine;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;

import static org.junit.Assert.assertEquals;

public class CarTest {

    Car car;
    Engine engine;
    FuelTank fuelTank;

    @Before
    public void before(){
        fuelTank = new FuelTank(50);
        engine = new Engine(1.8, fuelTank);
       car = new Car(5, 10000, "Ruby", engine);
    }

    @Test
    public void getPrice(){
        assertEquals(10000, car.getPrice(), 0.01);
    }

    @Test
    public void getCapacity(){
        assertEquals(5, car.getCapacity());
    }

    @Test
    public void getColour(){
        assertEquals("Ruby", car.getColour());
    }

    @Test
    public void getEngineSize(){
        assertEquals(1.8, car.getEngineSize(), 0.01);
    }

    @Test
    public void canGetFuelTankCapacity() {
        assertEquals(50, car.getFuelTankCapacityFromEngine(), 0.01);
    }

    @Test
    public void canDamage(){
        car.addDamage(1000.00);
        assertEquals(9000.00, car.getPrice(), 0.1);
    }
}
