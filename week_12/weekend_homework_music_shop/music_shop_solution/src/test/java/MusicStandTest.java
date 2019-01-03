import music_shop.MusicStand;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MusicStandTest {

    MusicStand stand;

    @Before
    public void before() {
        stand = new MusicStand("Silver", 5, 8);
    }

    @Test
    public void hasColour() {
        assertEquals("Silver", stand.getColour());
    }

    @Test
    public void hasBuyPrice() {
        assertEquals(5, stand.getBuyPrice());
    }

    @Test
    public void hasSellPrice() {
        assertEquals(8, stand.getSellPrice());
    }

    @Test
    public void canGetMarkUp() {
        assertEquals(3, stand.calculateMarkup());
    }


}
