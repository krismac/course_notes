import Components.CDPlayer;
import Components.Radio;
import Components.RecordPlayer;
import StereoStuff.Stereo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StereoTest {
    Stereo stereo;
    Radio radio;
    RecordPlayer recordPlayer;
    CDPlayer cdPlayer;

    @Before
    public void before() {
        radio = new Radio("Roberts", "Super DAB");
        cdPlayer = new CDPlayer( "Sony", "Disc Player", 3);
        recordPlayer = new RecordPlayer("Pioneer", "Disco Turntable");
        stereo = new Stereo("Keith's Music Blaster", radio, recordPlayer, cdPlayer);
    }

    @Test
    public void canGetName() {
        assertEquals("Keith's Music Blaster", stereo.getName());
    }

    @Test
    public void volumeStartsAtZero() {
        assertEquals(0, stereo.getCurrentVolume());
    }

    @Test
    public void canTurnUp() {
        stereo.turnItUp();
        assertEquals(1, stereo.getCurrentVolume());
    }

    @Test
    public void canTurnDown() {
        stereo.turnItUp();
        stereo.turnItUp();
        stereo.turnItDown();
        assertEquals(1, stereo.getCurrentVolume());
    }

    @Test
    public void cannotTurnSoundUpBeyondMax() {
        for (int i = 0; i < 20; i++) {
            stereo.turnItUp();
        }
        assertEquals(stereo.getMaxVolume(), stereo.getCurrentVolume());
    }

    @Test
    public void cannotTurnSoundDownBelowZero() {
        stereo.turnItUp();
        stereo.turnItUp();
        for (int i = 0; i < 20; i++) {
            stereo.turnItDown();
        }
        assertEquals(0, stereo.getCurrentVolume());
    }

    @Test
    public void canUseRadio() {
        String result = stereo.tuneRadio("Planet Rock");
        assertEquals("Radio Selected: Tuning to: Planet Rock",result);
    }

    @Test
    public void canUseCDPlayer() {
        String result = stereo.playCD("Number of the Beast");
        assertEquals("CD - Playing: Number of the Beast", result);
    }

    @Test
    public void canUseRecordPlayer() {
        String result = stereo.playRecord("Ace of Spades");
        assertEquals("Record Player - Playing: Ace of Spades", result);
    }

}
