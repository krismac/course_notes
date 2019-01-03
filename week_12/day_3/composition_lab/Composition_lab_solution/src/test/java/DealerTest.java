import components.Engine;
import components.FuelTank;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import people.Dealer;
import vehicles.Car;

import static org.junit.Assert.assertEquals;

public class DealerTest {
    Dealer dealer;
    Customer customer;
    Car car;
    Engine engine;
    FuelTank fuelTank;

    @Before
    public void before(){
        dealer = new Dealer("Bob", 50000.00);
        customer = new Customer("Sheila", 50000.00);
        fuelTank = new FuelTank(100);
        engine = new Engine(1.8, fuelTank);
        car = new Car(5, 10000, "Green", engine);

    }
    @Test
    public void canGetDealerName(){
        assertEquals("Bob", dealer.getName());
    }

    @Test
    public void canGetDealerMoney(){
        assertEquals(50000.00, dealer.getMoney(), 0.01);
    }

    @Test
    public void sellingCarIncreaseDealerMoney(){
        dealer.sellCar(car,customer);
        assertEquals(60000.00, dealer.getMoney(), 0.01);
    }

    @Test
    public void dealerCanBuyCar(){
        dealer.buyCar(car);
        assertEquals(1, dealer.vehicleCount());
        assertEquals(40000.00, dealer.getMoney(), 0.1);
    }

    @Test
    public void canRepairCar(){
        car.addDamage(5000.00);
        dealer.repairVehicle(5000.00, car);

        assertEquals(45000.00, dealer.getMoney(), 0.1);
        assertEquals(10000.00, car.getPrice(), 0.1);
    }
}
