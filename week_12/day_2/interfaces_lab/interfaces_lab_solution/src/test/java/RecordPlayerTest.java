import Components.RecordPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecordPlayerTest {
    RecordPlayer recordPlayer;

    @Before
    public void before() {
        recordPlayer = new RecordPlayer("Pioneer", "Disco Turntable");
    }

    @Test
    public void canGetMake() {
        assertEquals("Pioneer", recordPlayer.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Disco Turntable", recordPlayer.getModel());
    }

    @Test
    public void canPlay() {
        String result = recordPlayer.play("Back in Black");
        assertEquals("Record Player - Playing: Back in Black", result);
    }
}
