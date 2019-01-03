import ThemePark.Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestVisitor {
    Visitor visitor1;

    @Before
    public void before(){
        visitor1 = new Visitor(16, 146, 5.60);
    }

    @Test
    public void visitorHasInfo(){
        assertEquals(16,visitor1.getAge());
        assertEquals(146,visitor1.getHeightInCm());
        assertEquals(5.60,visitor1.getMoney(),0.01);
    }
}
