import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;

    @Before
    public void before(){
        book = new Book("Colour of Magic", "Terry Pratchett", "Fantasy");
    }

    @Test
    public void hasTitle(){
        assertEquals("Colour of Magic", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Terry Pratchett", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Fantasy", book.getGenre());
    }

}
