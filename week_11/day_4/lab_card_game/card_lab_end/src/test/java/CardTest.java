import static org.junit.Assert.*;
        import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.ACE);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS,card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void aceHasValueOf1(){
        assertEquals(1, card.getValue());
    }




}