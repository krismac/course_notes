package rooms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MonsterRoomTest {

    MonsterRoom room;

    @Before
    public void before(){
        room = new MonsterRoom();
    }

    @Test
    public void hasMonster(){
        assertNotNull(room.getEnemy());
    }

    @Test
    public void canNotExit(){
        assertEquals(false, room.canExit());
    }
}
