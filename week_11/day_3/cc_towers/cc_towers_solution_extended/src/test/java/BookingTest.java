import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Booking booking;
    Bedroom room;

    @Before
    public void before(){
        room = new Bedroom(101, "Single", 12, 50.00);
        booking = new Booking(room, 3);
    }

   @Test
    public void canGetBill(){
        assertEquals(150.0, booking.getTotalBill(), 0.1);
   }




}
