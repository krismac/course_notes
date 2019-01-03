import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BearTest {
    Bear bear;

    @Before
    public void before(){
        bear = new Bear("Baloo", 25, 95.62);
    }

    @Test
    public void hasName(){
        assertEquals( "Baloo", bear.getName() );
    }
    @Test
    public void hasAge(){
        assertEquals( 25, bear.getAge() );
    }

    @Test
    public void hasWeight(){
        assertEquals( 95.62, bear.getWeight(), 0.01 );
    }

    public void readyToHibernateIfGreaterThan80(){
        assertEquals( true, bear.readyToHibernate() );
    }
    @Test
    public void notreadyToHibernateIfLessThanEqual80(){
        Bear thinBear = new Bear("Baloo", 25, 65.44);
        assertEquals( false, thinBear.readyToHibernate() );
    }
}
