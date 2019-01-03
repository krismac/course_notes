import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCard(Card card){
        this.hand.add(card);
    }

    public int numberOfCards(){
        return this.hand.size();
    }

    public void emptyHand(){
        this.hand.clear();
    }

    public int getHandValue(){
        int total = 0;
        for (Card card : this.hand){
            total += card.getValue();
        }
        return total;

    }
}
