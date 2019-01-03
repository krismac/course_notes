import Outputs.Speaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeakerTest {
    Speaker speaker;

    @Before
    public void before() {
        speaker = new Speaker(400);
    }

    @Test
    public void canGetMaxOutput() {
        assertEquals(400, speaker.getMaxOutput());
    }

    @Test
    public void canBlastOutSounds() {
        assertEquals("Blasting out Iron Maiden to the world!", speaker.blastSound("Iron Maiden"));
    }
}
