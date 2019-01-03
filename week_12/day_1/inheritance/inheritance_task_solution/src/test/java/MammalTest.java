import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MammalTest {

    Mammal mammal;

    @Before
    public void before(){
        mammal = new Mammal();
    }

    @Test
    public void canEat(){
        assertEquals( "Mmmmm!", mammal.eat());
    }

    @Test
    public void canBreathe(){
        assertEquals("Huff, puff", mammal.breathe());
    }

    @Test
    public void canTalk(){
        assertEquals("Hello there!", mammal.talk());
    }
}
