import org.junit.*;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Colin");
    }

    @Test
    public void passengerHasName(){
        assertEquals("Colin", passenger.getName());
    }

}
