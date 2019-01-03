import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Printertest {

    private Printer printer;

    @Before
    public void setUp() {
        printer = new Printer(100, 200);
    }

    @Test
    public void hasPaper(){
        assertEquals(100, printer.getPaperCount());
    }

    @Test
    public void hasToner() {
        assertEquals(200, printer.getTonerVolume());
    }

    @Test
    public void canPrint(){
        printer.print(20, 4);
        assertEquals(20, printer.getPaperCount());
        assertEquals(120, printer.getTonerVolume());
    }

    @Test
    public void cannotPrintNoPaper(){
        printer.print(40, 5);
        assertEquals(100, printer.getPaperCount());
        assertEquals(200, printer.getTonerVolume());
    }
}
