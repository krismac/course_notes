import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {
    ConferenceRoom room;
    Guest guest1;

    @Before
    public void before() {
        room = new ConferenceRoom("Ada Lovelace Suite", 100, 1000.00);
        guest1 = new Guest("Alan Turing");
    }

    @Test
    public void hasName() {
        assertEquals("Ada Lovelace Suite", room.getName());
    }

    @Test
    public void hasCapacity() {
        assertEquals(100, room.getCapacity());
    }

    @Test
    public void hasPricePerDay() {
        assertEquals(1000, room.getPricePerDay(), 0.01);
    }

    @Test
    public void startsEmpty(){
        assertEquals(0, room.numberOfGuests());
    }

    @Test
    public void canCheckIn(){
        room.checkIn(guest1);
        assertEquals(1, room.numberOfGuests());
    }

    @Test
    public void cannotCheckInIfFull(){
        for (int i = 0; i <100; i++){
            room.checkIn(guest1);
        }

        room.checkIn(guest1);
        assertEquals(100, room.numberOfGuests());
    }
}
