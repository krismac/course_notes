import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    Person person;

    @Before
    public void before(){
        person = new Person("Ally", "G3");
    }


    @Test
    public void hasName(){
        assertEquals("Ally", person.getName());
    }

    @Test
    public void hasCohort(){
        assertEquals("G3", person.getCohort());
    }

    @Test
    public void canChangeName(){
        person.setName("Sandy");
        assertEquals("Sandy", person.getName());
    }
    @Test
    public void canChangeCohort(){
        person.setCohort("G4");
        assertEquals("G4", person.getCohort());
    }

    @Test
    public void canTalk(){
        assertEquals("I love Java", person.talk("Java"));
    }
}
