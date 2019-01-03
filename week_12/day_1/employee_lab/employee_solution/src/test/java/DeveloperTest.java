import org.junit.Before;
import org.junit.Test;
import techStaff.Developer;

import static org.junit.Assert.assertEquals;

public class DeveloperTest {

    Developer developer;

    @Before
    public void before(){
        developer = new Developer("Alice Reed", "J487628D", 24000.00);
    }

    @Test
    public void hasName(){
        assertEquals("Alice Reed", developer.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("J487628D", developer.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(24000.00, developer.getSalary(), 0.1);
    }

    @Test
    public void canRaiseSalary(){
        developer.raiseSalary(4000.00);
        assertEquals( 28000.00, developer.getSalary(), 0.1);
    }

    @Test
    public void canGetBonus(){
        assertEquals(240.00, developer.payBonus(), 0.1);
    }

}
