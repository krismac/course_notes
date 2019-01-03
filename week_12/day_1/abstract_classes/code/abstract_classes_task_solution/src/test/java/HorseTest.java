import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HorseTest {
    Horse horse;

    @Before
    public void before() {
        horse = new Horse("pony");
    }

    @Test
    public void hasBreed() {
        assertEquals("pony", horse.getBreed());
    }

    @Test
    public void canMakeNoise() {
        assertEquals("neigh", horse.makeANoise());
    }

    @Test
    public void canSingTheSong() {
        assertEquals("Hi, I am a horse from pony family, neigh", horse.introduceYourself());
    }

}
