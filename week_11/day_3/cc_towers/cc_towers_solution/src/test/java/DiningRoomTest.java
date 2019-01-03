import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom room;
    Guest guest1;

    @Before
    public void before() {
        room = new DiningRoom("CC Canteen", 50);
        guest1 = new Guest("Alan Turing");
    }

    @Test
    public void hasName() {
        assertEquals("CC Canteen", room.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(50, room.getCapacity());
    }

    @Test
    public void canCheckIn(){
        room.checkIn(guest1);
        assertEquals(1, room.numberOfGuests());
    }

    @Test
    public void cannotCheckInIfFull(){
        for (int i = 0; i <50; i++){
            room.checkIn(guest1);
        }

        room.checkIn(guest1);
        assertEquals(50, room.numberOfGuests());
    }
}
