package cardGame.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class TwoCardHandTest {

    @Test
    public void testGetHigherRankingCardInTheHand() throws Exception {

        Card firstCard = new Card(Suit.CLUBS, Rank.ACE);
        Card secondCard = new Card(Suit.DIAMONDS, Rank.EIGHT);

        TwoCardsHand hand = new TwoCardsHand(firstCard, secondCard);

        assertThat(hand.getHigherRankingCardInTheHand(), equalTo(secondCard));
    }

    @Test
    public void testHasSameSuiteCards() throws Exception {

        Card firstCard = new Card(Suit.CLUBS, Rank.ACE);
        Card secondCard = new Card(Suit.CLUBS, Rank.EIGHT);

        TwoCardsHand firstTestHand = new TwoCardsHand(firstCard, secondCard);
        assertThat(firstTestHand.hasSameSuiteCards(), equalTo(true));

        firstCard = new Card(Suit.CLUBS, Rank.ACE);
        secondCard = new Card(Suit.DIAMONDS, Rank.EIGHT);

        TwoCardsHand secondTestHand = new TwoCardsHand(firstCard, secondCard);
        assertThat(secondTestHand.hasSameSuiteCards(), equalTo(false));
    }

    @Test
    public void testHasSameRankCards() throws Exception {

        Card firstCard = new Card(Suit.DIAMONDS, Rank.ACE);
        Card secondCard = new Card(Suit.CLUBS, Rank.ACE);

        TwoCardsHand firstTestHand = new TwoCardsHand(firstCard, secondCard);
        assertThat(firstTestHand.hasSameRankCards(), equalTo(true));

        firstCard = new Card(Suit.CLUBS, Rank.ACE);
        secondCard = new Card(Suit.DIAMONDS, Rank.EIGHT);

        TwoCardsHand secondTestHand = new TwoCardsHand(firstCard, secondCard);
        assertThat(secondTestHand.hasSameRankCards(), equalTo(false));
    }
}