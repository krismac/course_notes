import Components.CDPlayer;
import Components.Radio;
import Components.RecordPlayer;
import StereoStuff.MP3Player;
import StereoStuff.Stereo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MP3PlayerTest {
    MP3Player mp3Player;
    Stereo stereo;
    Radio radio;
    RecordPlayer recordPlayer;
    CDPlayer cdPlayer;

    @Before
    public void before() {
        radio = new Radio("Roberts", "Super DAB");
        cdPlayer = new CDPlayer("Sony", "Disc Player", 3);
        recordPlayer = new RecordPlayer("Pioneer", "");
        stereo = new Stereo("Upul's MegaSound Blaster", radio, recordPlayer, cdPlayer);
        mp3Player = new MP3Player("Creative", "Zen Micro");
    }

    @Test
    public void canGetMake() {
        assertEquals("Creative", mp3Player.getMake());
    }

    @Test
    public void canGetModel() {
        assertEquals("Zen Micro", mp3Player.getModel());
    }

    @Test
    public void canConnectToStereo() {
        String result = mp3Player.connect(stereo);
        assertEquals("Connected to: Upul's MegaSound Blaster", result);
    }

}
