import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SheepTest {
    Sheep sheep;

    @Before
    public void before() {
        sheep = new Sheep();
    }

    @Test
    public void canMakeNoise() {
        assertEquals("baa", sheep.makeANoise());
    }

    @Test
    public void canSingTheSong() {
        assertEquals("Hi, I am a sheep, baa", sheep.introduceYourself());
    }

}
