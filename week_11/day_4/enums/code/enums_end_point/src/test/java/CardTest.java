import static org.junit.Assert.*;
import org.junit.*;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
    }

    @Test
    public void canGetSuit(){
        assertEquals(SuitType.HEARTS, card.getSuit());
    }

    @Test
    public void canGetValue(){
        assertEquals(RankType.QUEEN, card.getRank());
    }

    @Test
    public void queenHasValue10(){
        card = new Card(SuitType.HEARTS, RankType.QUEEN);
        assertEquals(10, card.getValueFromEnum());
    }

    //@Test
    //public void suitCanBeMispelled(){
    //  card = new Card("Heeaarts");
    //  assertEquals("Heeaarts", card.getSuit());
    //}

    //@Test
    //public void suitCanBeBananas(){
    //  card = new Card("Bananas");
    //  assertEquals("Bananas", card.getSuit());
    //}
}