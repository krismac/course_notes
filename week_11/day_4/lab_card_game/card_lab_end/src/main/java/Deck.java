import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        populateDeck();
        shuffleDeck();
    }

    private void populateDeck(){

        for (Suit suit : Suit.values()){
            for (Rank rank : Rank.values()){
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
    }

    public int numberOfCards(){
        return this.cards.size();
    }

    public void shuffleDeck(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard(){
        return this.cards.remove(0);
    }
}
