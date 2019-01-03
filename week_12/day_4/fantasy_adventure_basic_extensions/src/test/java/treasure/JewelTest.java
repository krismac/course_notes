package treasure;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class JewelTest {

    Jewel jewel;

    @Before
    public void before(){
        jewel = new Jewel();
    }

    @Test
    public void hasValue(){
        assertEquals(250, jewel.getValue());
    }
}
