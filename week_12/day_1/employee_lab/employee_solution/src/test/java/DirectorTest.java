import management.Director;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectorTest {
    Director director;

    @Before
    public void before(){
        director = new Director("Buzz Killington", "JK635473A", 52000.00, "User Experience", 1000.00);
    }

    @Test
    public void hasName(){
        assertEquals("Buzz Killington", director.getName());
    }

    @Test
    public void hasNiNumber(){
        assertEquals("JK635473A", director.getNiNumber());
    }

    @Test
    public void hasSalary(){
        assertEquals(52000.00, director.getSalary(), 0.1);
    }

    @Test
    public void hasDeptName(){
        assertEquals("User Experience", director.getDeptName());
    }

    @Test
    public void hasBudget(){
        assertEquals(1000.00, director.getBudget(), 0.1);
    }

    @Test
    public void canRaiseSalary(){
        director.raiseSalary(7000.00);
        assertEquals( 59000.00, director.getSalary(), 0.1);
    }

    @Test
    public void canGetBonus(){
        assertEquals(1040, director.payBonus(), 0.1);
    }
}
