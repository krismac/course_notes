import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    Human dave;

    @Before
    public void before(){
        dave = new Human();
    }
    @Test
    public void canEat(){
        assertEquals("Mmmmm!", dave.eat());
    }

    @Test
    public void canBreathe(){
        assertEquals("Huff, puff", dave.breathe());
    }

    @Test
    public void canWalk(){
        assertEquals("What a lovely day for a stroll, pip pip old boy!", dave.walk());
    }

    @Test
    public void canTalk(){
        assertEquals("Hello there!", dave.talk());
    }
}
