import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InternetRadioTest {
    InternetRadio radio;

    @Before
    public void before() {
        radio = new InternetRadio();
    }

    @Test
    public void canConnect(){
        assertEquals("connecting to network: CodeClan. Ready to Rock'n'Roll", radio.connect("CodeClan"));
    }

    @Test
    public void canTune(){
        assertEquals("tuning to Planet Rock", radio.tune("Planet Rock"));
    }
}
