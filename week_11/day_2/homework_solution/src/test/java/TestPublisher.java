import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestPublisher {

    private Book book;
    private Publisher publisher;

    @Before
    public void before(){
        book = new Book("Thud", "Terry Pratchett", "Crime");
        publisher = new Publisher("Penguin");
    }


    @Test
    public void publishersStartsEmpty(){
        assertEquals(0, publisher.getStockCount());
    }

    @Test
    public void canAddBook(){
        publisher.adBookToStock(book);
        assertEquals(1, publisher.getStockCount());
    }

    @Test
    public void canRemoveBook(){
        publisher.adBookToStock(book);
        assertEquals(1, publisher.getStockCount());
        Book bought = publisher.getBook();
        assertEquals(0, publisher.getStockCount());
        assertNotNull(bought);
    }


}
