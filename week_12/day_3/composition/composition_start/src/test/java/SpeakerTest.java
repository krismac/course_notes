import device_management.Speaker;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SpeakerTest {
    Speaker speaker;

    @Before
    public void before() {
        speaker = new Speaker(100);
    }

    @Test
    public void hasMaxVolume() {
        assertEquals(100, speaker.getMaxVolume());
    }

    @Test
    public void canTune() {
        assertEquals("playing: Beep", speaker.outputData("Beep"));
    }
}
