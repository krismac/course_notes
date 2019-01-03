import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBus {

    private Bus bus;
    private BusStop stop;
    private Person person;

    @Before
    public void before() {
        bus = new Bus("Stirling", 10);
        stop = new BusStop("The Quay");
        person = new Person();
    }

    @Test
    public void canGetPassengerCount(){
        assertEquals(0, bus.getPassengerCount());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.getPassengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.getPassengerCount());
        bus.removePassenger(person);
        assertEquals(0, bus.getPassengerCount());
    }

    @Test
    public void cantAddMoreThanCapacity(){
        for (int i = 0; i<12; i++){
            bus.addPassenger(person);
        }
        assertEquals(10, bus.getPassengerCount());
    }

    @Test
    public void canPickUpFromBusStop(){
        stop.addPerson(person);
        bus.pickUp(stop);
        assertEquals(1, bus.getPassengerCount());
    }

}
