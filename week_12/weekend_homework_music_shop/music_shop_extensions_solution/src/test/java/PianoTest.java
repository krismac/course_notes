import music_shop.InstrumentType;
import music_shop.Piano;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PianoTest {

    Piano piano;

    @Before
    public void before() {
        piano = new Piano("Steinway", "Black", 1500, 1800);
    }

    @Test
    public void hasManufacturer() {
        assertEquals("Steinway", piano.getManufacturer());
    }

    @Test
    public void hasColour() {
        assertEquals("Black", piano.getColour());
    }

    @Test
    public void hasType() {
        assertEquals(InstrumentType.KEYBOARD, piano.getType());
    }

    @Test
    public void canPlay() {
        assertEquals("Plink Plonk", piano.play());
    }

    @Test
    public void hasBuyPrice() {
        assertEquals(1500, piano.getBuyPrice());
    }

    @Test
    public void hasSellPrice() {
        assertEquals(1800, piano.getSellPrice());
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(300, piano.calculateMarkup());
    }
}