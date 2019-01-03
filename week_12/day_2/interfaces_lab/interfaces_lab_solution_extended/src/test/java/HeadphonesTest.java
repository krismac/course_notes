import Outputs.Headphones;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadphonesTest {
    Headphones headphones;

    @Before
    public void before() {
        headphones = new Headphones("Cheepo", "Earbuds");
    }

    @Test
    public void canGetMake() {
        assertEquals("Cheepo", headphones.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Earbuds", headphones.getModel());
    }

    @Test
    public void canBlastOut() {
        assertEquals("Playing Mozart in your ears.", headphones.blastSound("Mozart"));
    }


}
