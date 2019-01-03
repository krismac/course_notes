import device_management.Radio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RadioTest {
    Radio radio;

    @Before
    public void before() {
        radio = new Radio(70);
    }

    @Test
    public void hasMaxVolume() {
        assertEquals(70, radio.getMaxVolume());
    }

    @Test
    public void canTune() {
        assertEquals("playing: Planet Rock", radio.tune("Planet Rock"));
    }
}
