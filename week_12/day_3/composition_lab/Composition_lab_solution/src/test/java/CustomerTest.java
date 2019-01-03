import org.junit.Before;
import org.junit.Test;
import people.Customer;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    Customer customer;

    @Before
    public void before(){
        customer = new Customer("Sheila", 50000.00);
    }
    @Test
    public void canGetCustomerName(){
        assertEquals("Sheila", customer.getName());
    }

    @Test
    public void canGetCustomerMoney(){
        assertEquals(50000.00, customer.getMoney(), 0.01);
    }
}
