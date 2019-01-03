import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GameTest {

    Game game;
    Dealer dealer;
    Player player1;
    Player player2;
    Deck deck;

    @Before()
    public void before(){
        deck = new Deck();
        dealer = new Dealer();
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(deck, dealer, players);
    }

    @Test
    public void canPlay(){
        game.play();

        assertEquals(1, player1.numberOfCards());
        assertEquals(1, player2.numberOfCards());
        assertEquals(50, deck.numberOfCards());
    }

    @Test
    public void player1Wins(){
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.FIVE));
        assertEquals(player1, game.checkWinner());
    }

    @Test
    public void drawReturnsNull(){
        player1.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        player2.addCard(new Card(Suit.HEARTS, Rank.EIGHT));
        assertNull(game.checkWinner());
    }


}
