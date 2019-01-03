import device_management.Monitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MonitorTest {
    Monitor monitor;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
    }

    @Test
    public void hasScreenSize() {
        assertEquals(22, monitor.getScreenSize());
    }

    @Test
    public void hasPixels() {
        assertEquals(786432, monitor.getPixels());
    }

    @Test
    public void canProcessData() {
        assertEquals("space invaders is now on screen", monitor.outputData("space invaders"));
    }

}
