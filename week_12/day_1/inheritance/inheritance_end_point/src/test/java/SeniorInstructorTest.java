import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SeniorInstructorTest {

    SeniorInstructor seniorInstructor;

    @Before
    public void before(){
        seniorInstructor = new SeniorInstructor("Keith", "E17", "JavaScript", "Teaching Staff");
    }


    @Test
    public void hasName(){
        assertEquals("Keith", seniorInstructor.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("E17", seniorInstructor.getCohort());
    }

    @Test
    public void canChangeName(){
        seniorInstructor.setName("Darren");
        assertEquals("Darren", seniorInstructor.getName());
    }
    @Test
    public void canChangeCohort(){
        seniorInstructor.setCohort("E20");
        assertEquals("E20", seniorInstructor.getCohort());
    }

    @Test
    public void hasHiringTeam(){
        assertEquals("Teaching Staff", seniorInstructor.getHiringTeam());
    }

    @Test
    public void canTalk(){
        assertEquals("I love Java", seniorInstructor.talk("Java"));
    }
}
