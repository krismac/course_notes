import Components.Radio;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadioTest {

    Radio radio;

    @Before
    public void before() {
        radio = new Radio("Roberts", "Super DAB");
    }

    @Test
    public void canGetMake() {
        assertEquals("Roberts", radio.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Super DAB", radio.getModel());
    }

    @Test
    public void canTune() {
        assertEquals("Tuning to: Absolute Rock", radio.tune("Absolute Rock"));
    }
}
