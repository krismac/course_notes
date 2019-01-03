import org.junit.Before;
import org.junit.Test;
import techStaff.DatabaseAdmin;

import static org.junit.Assert.assertEquals;

public class DatabaseAdminTest {

    DatabaseAdmin databaseAdmin;

    @Before
    public void before(){
        databaseAdmin = new DatabaseAdmin("Kevin Hunter", "JR362719B", 24000.00);
    }

    @Test
    public void hasName(){
        assertEquals("Kevin Hunter", databaseAdmin.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("JR362719B", databaseAdmin.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(24000.00, databaseAdmin.getSalary(), 0.1);
    }

    @Test
    public void canRaiseSalary(){
        databaseAdmin.raiseSalary(2000.00);
        assertEquals( 26000.00, databaseAdmin.getSalary(), 0.1);
    }

    @Test
    public void canGetBonus(){
        assertEquals(240.00, databaseAdmin.payBonus(), 0.1);
    }
}
