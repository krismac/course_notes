import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FlightTest {

    private Plane plane;
    private Airport airport;
    private Flight flight;
    private Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.LEARJET, "CCAir");
        airport = new Airport("EDI");
        flight = new Flight(plane, 0001, airport);
        passenger = new Passenger("Colin");
    }

    @Test
    public void hasPlane(){
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void hasNumber(){
        assertEquals(0001, flight.getNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals(airport, flight.getDestination());
    }

    @Test
    public void canCheckSeatsAvailable(){
        assertTrue(flight.checkSeatsAvailable());
    }

    @Test
    public void canCheckNoSeatsAvailable(){
        Plane smallPlane = new Plane(PlaneType.CESSNA, "tempAir");
        Flight tempFlight = new Flight(smallPlane, 9999, airport);
        tempFlight.addTicket(passenger);
        tempFlight.addTicket(passenger);
        tempFlight.addTicket(passenger);
        tempFlight.addTicket(passenger);
        assertFalse(tempFlight.checkSeatsAvailable());
    }

    @Test
    public void canAddTicket(){
        flight.addTicket(passenger);
        assertEquals(1, flight.getTicketsSold());
    }

    @Test
    public void canSetPlane(){
        Plane newPlane = new Plane(PlaneType.AIRBUS_A320, "TempAir");
        flight.setPlane(newPlane);
        assertEquals(newPlane, flight.getPlane());
    }

}
