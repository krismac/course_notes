import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestBusStop {

    private BusStop stop;
    private Person person;

    @Before
    public void before(){
        stop = new BusStop("The Quay");
        person  = new Person();
    }

    @Test
    public void canAddToQueue(){
        stop.addPerson(person);
        assertEquals(1, stop.getQueueCount());
    }

    @Test
    public void canReoveFromQueue(){
        stop.addPerson(person);
        Person removed = stop.removePerson();
        assertNotNull(removed);
        assertEquals(0, stop.getQueueCount());
    }
}
