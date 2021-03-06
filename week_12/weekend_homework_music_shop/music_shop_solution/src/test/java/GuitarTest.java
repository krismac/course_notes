import music_shop.Guitar;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GuitarTest {

    Guitar guitar;

    @Before
    public void before() {
        guitar = new Guitar("Gibson SG","Cherry Red", 6, 400, 500);
    }

    @Test
    public void hasModel() {
        assertEquals("Gibson SG", guitar.getModel());
    }

    @Test
    public void hasColour() {
        assertEquals("Cherry Red", guitar.getColour());
    }

    @Test
    public void hasType() {
        assertEquals("String", guitar.getType());
    }

    @Test
    public void hasNumberOfStrings() {
        assertEquals(6, guitar.getNumberOfStrings());
    }

    @Test
    public void canPlay() {
        assertEquals("Kerrang!!!", guitar.play());
    }

    @Test
    public void hasCostPrice() {
        assertEquals(400, guitar.getCostPrice());
    }

    @Test
    public void hasRetailPrice() {
        assertEquals(500, guitar.getRetailPrice());
    }

    @Test
    public void canGetMarkup() {
        assertEquals(100, guitar.calculateMarkup());
    }


}
