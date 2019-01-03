import device_management.Television;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {
    Television tv;

    @Before
    public void before() {
        tv = new Television(49, 921600);
    }

    @Test
    public void hasScreenSize() {
        assertEquals(49, tv.getScreenSize());
    }

    @Test
    public void hasPixels() {
        assertEquals(921600, tv.getPixels());
    }

    @Test
    public void canTune() {
        assertEquals("tuning to: BBC1", tv.tune("BBC1"));
    }

    @Test
    public void canDisplay() {
        assertEquals("BBC1 is now on screen", tv.display("BBC1"));
    }
}
