package treasure;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GoldTest {

    Gold gold;

    @Before
    public void before(){
        gold = new Gold();
    }

    @Test
    public void hasValue(){
        assertEquals(100, gold.getValue());
    }
}
