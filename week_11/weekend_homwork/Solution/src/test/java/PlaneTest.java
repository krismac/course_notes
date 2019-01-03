import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;
    private Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.LEARJET, "CCAir");
        passenger = new Passenger("Colin");
    }

    @Test
    public void hasType(){
        assertEquals(PlaneType.LEARJET, plane.getType());
    }

    @Test
    public void hasAirline(){
        assertEquals("CCAir", plane.getAirline());
    }

    @Test
    public void passengerListStartsEmpty(){
        assertEquals(0, plane.getPassengers().size());
    }

    @Test
    public void canGetCapacity(){
        assertEquals(25, plane.getCapacity());
    }

    @Test
    public void canCheckAvailableSeats(){
        assertEquals(25, plane.getAvailableSeats());
    }

    @Test
    public void canAddPassenger(){
        plane.addPassenger(passenger);
        assertEquals(24, plane.getAvailableSeats());
    }

    @Test
    public void canReportTicketsSold(){
        plane.addPassenger(passenger);
        assertEquals(1, plane.getTicketsSold());
    }

    @Test
    public void correctReportIfNoTicketsSold(){
        assertEquals(0, plane.getTicketsSold());
    }

}
