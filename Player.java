import java.util.LinkedList;
import java.util.Random;

public class Player {

   private int playerNum;
    private LinkedList<Card> hand;
    private String pattern;
    private Card lastPlayedCard;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        this.hand = new LinkedList<>();
        this.pattern = Game.patterns[new Random().nextInt(Game.patterns.length)];
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            lastPlayedCard = hand.removeFirst();
            //return hand.removeFirst();
            return lastPlayedCard;
        } else {
            return null;
        }
    }

    public boolean slaps(LinkedList<Card> pile) {
        switch (pattern) {
            case "doubles":
                return Game.doubles(pile);
            case "top bottom":
                return Game.topBottom(pile);
            case "sandwich":
                return Game.sandwich(pile);
            default:
                return false;
        }
    }

    // Accessor methods
    public int getPlayerNum() {
        return playerNum;
    }

    public LinkedList<Card> getHand() {
        return hand;
    }

    public String getPattern() {
        return pattern;
    }

    public Card getLastPlayedCard() {
        return lastPlayedCard;
    }


    public String toString() {
        return "Player " + playerNum + ": Pattern - " + pattern + ", Hand - " + hand;
    }

}