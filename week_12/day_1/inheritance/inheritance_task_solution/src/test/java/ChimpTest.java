import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChimpTest {

    Chimpanzee cheeta;

    @Before
    public void before(){
        cheeta = new Chimpanzee();
    }
    @Test
    public void canEat(){
        assertEquals("Mmmmm!", cheeta.eat());
    }

    @Test
    public void canBreathe(){
        assertEquals("Huff, puff", cheeta.breathe());
    }

    @Test
    public void canWalk(){
        assertEquals("I wanna walk like you!", cheeta.walk());
    }

    @Test
    public void canTalk(){
        assertEquals("Hello there!", cheeta.talk());
    }


}
