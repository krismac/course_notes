import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkTest {

    Network network;
    Desktop desktop;
    Printer printer;
    InternetRadio radio;

    @Before
    public void before() {
        network = new Network("CodeClan", 3);
        desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
        printer = new Printer();
        radio = new InternetRadio();
    }

    @Test
    public void hasName(){
        assertEquals("CodeClan", network.getName());
    }

    @Test
    public void hasMaxConnections(){
        assertEquals(3, network.getMaxConnections());
    }

    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canConnectDesktop() {
        network.connect(desktop);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectPrinter() {
        network.connect(printer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectInternetRadio() {
        network.connect(radio);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll(){
        network.connect(desktop);
        network.connect(printer);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void canGetFreeSlots() {
        network.connect(radio);
        assertEquals(2, network.freeSlots());
    }

    @Test
    public void cannotConnectIfNoFreeSlotsAvailable() {
        Desktop desktop2 = new Desktop("Sian's Desktop", "Apple", "MacBook Pro");
        network.connect(radio);
        network.connect(desktop);
        network.connect(printer);
        network.connect(desktop2);

        assertEquals(3, network.deviceCount());
        assertEquals(0, network.freeSlots());
    }

}
