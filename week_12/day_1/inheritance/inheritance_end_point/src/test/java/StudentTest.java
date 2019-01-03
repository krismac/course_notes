import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    Student student;

    @Before
    public void before(){
        student = new Student("Alex", "G3");
    }


    @Test
    public void hasName(){
        assertEquals("Alex", student.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("G3", student.getCohort());
    }

    @Test
    public void canChangeName(){
        student.setName("Clare");
        assertEquals("Clare", student.getName());
    }
    @Test
    public void canChangeCohort(){
        student.setCohort("G4");
        assertEquals("G4", student.getCohort());
    }

    @Test
    public void canTalk(){
        assertEquals("I love learning Java", student.talk("Java"));
    }
}
