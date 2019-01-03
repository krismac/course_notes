import device_management.Printer;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PrinterTest {
    Printer printer;

    @Before
    public void before() {
        printer = new Printer("Epson", "Stylus", 120, 4);
    }

    @Test
    public void hasMake() {
        assertEquals("Epson", printer.getMake());
    }

    @Test
    public void hasModel() {
        assertEquals("Stylus", printer.getModel());
    }

    @Test
    public void hasDpi() {
        assertEquals(120, printer.getDpi());
    }

    @Test
    public void hasPrintSpeed() {
        assertEquals(4, printer.getPrintSpeed());
    }

    @Test
    public void canProcessData() {
        assertEquals("printing: Hello World", printer.outputData("Hello World"));
    }
}
