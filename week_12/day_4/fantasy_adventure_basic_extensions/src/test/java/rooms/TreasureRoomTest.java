package rooms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class TreasureRoomTest {

    TreasureRoom room;

    @Before
    public void before(){
        room = new TreasureRoom();
    }


    @Test
    public void testRandomNumber(){
        int result = room.getRandomNumber(3);
        boolean expected = result >= 0 && result <3;
        assertEquals(true, expected);
    }

    @Test
    public void testHasTreasure(){
        assertNotNull(room.getTreasure());
    }

    @Test
    public void canNotExit(){
        assertEquals(false, room.canExit());
    }


}
