import java.util.ArrayList;

public class Game {

    private Deck deck;
    private Dealer dealer;
    private ArrayList<Player> players;

    public Game(Deck deck, Dealer dealer, ArrayList<Player> players) {
        this.deck = deck;
        this.dealer = dealer;
        this.players = players;
    }

    public void play() {
        for (Player player : this.players) {
            Card card = dealer.deal(deck);
            player.addCard(card);
        }
    }


    public Player checkWinner() {
        if (checkDraw()) {
            return null;
        }
        Player winner = players.get(0);

        for (Player player : this.players) {
            if (player.getHandValue() > winner.getHandValue()) {
                winner = player;
            }
        }

        return winner;
    }

    public boolean checkDraw() {
        boolean draw = false;
        for (Player player : players) {
            if (player.getHandValue() == players.get(0).getHandValue()) {
                draw = true;
            } else {
                draw = false;
            }
        }
        return draw;
    }
}
