import management.Manager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    Manager manager;

    @Before
    public void before(){
        manager = new Manager("Stephanie McIntyre", "JR362719B", 38000.00, "Devops");
    }

    @Test
    public void hasName(){
        assertEquals("Stephanie McIntyre", manager.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("JR362719B", manager.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(38000.00, manager.getSalary(), 0.1);
    }

    @Test
    public void hasDeptName(){
        assertEquals("Devops", manager.getDeptName());
    }

    @Test
    public void canRaiseSalary(){
        manager.raiseSalary(1500.00);
        assertEquals( 39500.00, manager.getSalary(), 0.1);
    }

    @Test
    public void canGetBonus(){
        assertEquals(380.00, manager.payBonus(), 0.1);
    }
}
