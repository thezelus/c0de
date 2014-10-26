package cardGame.model;

public class TwoCardsHand {

    private final Card firstCard;
    private final Card secondCard;

    @Override
    public String toString() {
        return "{" + "firstCard=" + firstCard.toString() + ", secondCard=" + secondCard.toString() + '}';
    }

    public TwoCardsHand(Card firstCard, Card secondCard) {
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

    public Card getHigherRankingCardInTheHand(){
        if(firstCard.getRank().getFaceValue() >= secondCard.getRank().getFaceValue())
            return firstCard;
        else
            return secondCard;
    }

    public boolean hasSameSuiteCards(){
        return firstCard.getSuit().equals(secondCard.getSuit());
    }

    public boolean hasSameRankCards(){
        return firstCard.getRank().getFaceValue() == secondCard.getRank().getFaceValue();
    }

}
