import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {
    Bedroom singleRoom;
    Bedroom doubleRoom;

    Guest guest1;
    Guest guest2;

    @Before
    public void before() {
        singleRoom = new Bedroom(101, "Single", 1, 25.00);
        doubleRoom = new Bedroom(102, "Double", 2, 50.00);

        guest1 = new Guest("Ada Lovelace");
        guest2 = new Guest("Alan Turing");
    }

    //SINGLE ROOMS
    @Test
    public void singleRoomHasNumber() {
        assertEquals(101, singleRoom.getNumber());
    }

    @Test
    public void singleRoomHasRoomType() {
        assertEquals("Single", singleRoom.getType());
    }

    @Test
    public void singleRoomHasRoomPricePerNight() {
        assertEquals(25.00, singleRoom.getPricePerNight(), 0.01);
    }

    @Test
    public void singleRoomHasCapacity() {
        assertEquals(1, singleRoom.getCapacity());
    }


    @Test
    public void singleRoomStartsVacant() {
        assertEquals(false, singleRoom.isFull());
    }

    @Test
    public void singleRoomStartsEmpty() {
        assertEquals(0, singleRoom.numberOfGuests());
        assertEquals(false, singleRoom.isFull());
    }

    @Test
    public void canCheckIn(){
        singleRoom.checkIn(guest1);
        assertEquals(1, singleRoom.numberOfGuests());
    }

    @Test
    public void cannotCheckInIfFull(){
        singleRoom.checkIn(guest1);
        singleRoom.checkIn(guest2);
        assertEquals(1, singleRoom.numberOfGuests());
    }

    //DOUBLE ROOMS
    @Test
    public void doubleRoomHasNumber() {
        assertEquals(102, doubleRoom.getNumber());
    }

    @Test
    public void doubleRoomHasRoomType() {
        assertEquals("Double", doubleRoom.getType());
    }

    @Test
    public void doubleRoomHasRoomPricePerNight() {
        assertEquals(50.00, doubleRoom.getPricePerNight(), 0.01);
    }

    @Test
    public void doubleRoomHasCapacity() {
        assertEquals(2, doubleRoom.getCapacity());
    }


    @Test
    public void doubleRoomStartsVacant() {
        assertEquals(false, doubleRoom.isFull());
    }

    @Test
    public void doubleRoomStartsEmpty() {
        assertEquals(0, doubleRoom.numberOfGuests());
        assertEquals(false, doubleRoom.isFull());
    }

    @Test
    public void canCheckInDouble(){
        doubleRoom.checkIn(guest1);
        assertEquals(1, doubleRoom.numberOfGuests());
    }

    @Test
    public void cannotCheckInDoubleIfFull(){
        doubleRoom.checkIn(guest1);
        doubleRoom.checkIn(guest2);
        doubleRoom.checkIn(guest1);
        assertEquals(2, doubleRoom.numberOfGuests());
    }



}
