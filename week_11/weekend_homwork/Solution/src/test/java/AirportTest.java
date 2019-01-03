import org.junit.*;

import static org.junit.Assert.*;

public class AirportTest {

    private Airport airport1;
    private Airport airport2;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Flight flight1;
    private Flight flight2;
    private Passenger passenger;

    @Before
    public void before(){
        airport1 = new Airport("EDI");
        airport2 = new Airport("LHR");
        plane1 = new Plane(PlaneType.LEARJET, "CCAir");
        plane2 = new Plane(PlaneType.BOEING_747, "SleazyJet");
        plane3 = new Plane(PlaneType.CESSNA, "Scottish Airways");
        flight1 = new Flight(plane1, 1111, airport2);
        flight2 = new Flight(plane3, 1234, airport2);
        passenger = new Passenger("Colin");
    }

    @Test
    public void hasCode(){
        assertEquals("EDI", airport1.getCode());
    }

    @Test
    public void hangarStartsEmpty(){
        assertEquals(0, airport1.getHangar().size());
    }

    @Test
    public void canAddPlaneToHangar(){
        airport1.addToHangar(plane1);
        assertEquals(1, airport1.getHangar().size());
    }

    @Test
    public void canCheckHangarNotEmpty(){
        airport1.addToHangar(plane1);
        assertTrue(airport1.containsPlane());
    }

    @Test
    public void canCheckHangarIsEmpty(){
        assertFalse(airport1.containsPlane());
    }

    @Test
    public void canRemovePlaneFromHangar(){
        airport1.addToHangar(plane1);
        airport1.removeFromHangar(plane1);
        assertEquals(0, airport1.getHangar().size());
    }

    @Test
    public void removesCorrectPlaneFromHangar(){
        airport1.addToHangar(plane1);
        airport1.addToHangar(plane2);
        airport1.removeFromHangar(plane1);
        assertNotEquals(-1, airport1.getHangar().indexOf(plane2));
    }

    @Test
    public void cantRemovePlaneIfHangarEmpty(){
        airport1.removeFromHangar(plane1);
        assertEquals(0, airport1.getHangar().size());
    }

    @Test
    public void cantRemovePlaneIfNotInHangar(){
        airport1.addToHangar(plane2);
        airport1.removeFromHangar(plane1);
        assertEquals(1, airport1.getHangar().size());
    }

    @Test
    public void canCreateFlight(){
        airport1.addToHangar(plane1);
        Flight newFlight = airport1.createFlight(plane1, 0002, airport2);
        assertNotNull(newFlight);
    }

    @Test
    public void canSellTickets(){
        airport1.sellTicket(flight1, passenger);
        assertEquals(1, flight1.getTicketsSold());
    }

    @Test
    public void cantSellTicketToStartingAirport(){
        airport2.sellTicket(flight1, passenger);
        assertEquals(0, flight1.getTicketsSold());
    }

    @Test
    public void cantSellTicketIfFlightAlreadyFull(){
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        assertEquals(4, flight2.getTicketsSold());
    }

    @Test
    public void canReplacePlaneCorrectly(){
        airport1.addToHangar(plane2);
        airport1.addToHangar(plane3);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.replacePlane(flight1);
        assertEquals(plane2, flight1.getPlane());
    }

    @Test
    public void canReplacePlaneWithBestOption(){
        airport1.addToHangar(plane1);
        airport1.addToHangar(plane2);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.replacePlane(flight2);
        assertEquals(plane1, flight2.getPlane());
    }

    @Test
    public void wontReplacePlaneIfNoneAvailable(){
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.sellTicket(flight2, passenger);
        airport1.replacePlane(flight2);
        assertEquals(plane3, flight2.getPlane());
    }

    @Test
    public void wontReplacePlaneIfNoneSuitableAvailable(){
        airport1.addToHangar(plane3);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.sellTicket(flight1, passenger);
        airport1.replacePlane(flight1);
        assertEquals(plane1, flight1.getPlane());
    }


}
