package cardGame.model;

public class Card {

    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "{" + "suit=" + suit + ", rank=" + rank + '}';
    }
}
