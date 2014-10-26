package cardGame.util;

import cardGame.model.Card;
import cardGame.model.Rank;
import cardGame.model.Suit;
import cardGame.model.TwoCardsHand;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HandComparisonTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    TwoCardsHand handWithSameRank = new TwoCardsHand(new Card(Suit.CLUBS, Rank.KING), new Card(Suit.HEARTS, Rank.KING));
    TwoCardsHand handWithDifferentRank = new TwoCardsHand(new Card(Suit.CLUBS, Rank.EIGHT), new Card(Suit.DIAMONDS, Rank.NINE));

    TwoCardsHand handWithSameSuit = new TwoCardsHand(new Card(Suit.CLUBS, Rank.NINE), new Card(Suit.CLUBS, Rank.KING));
    TwoCardsHand handWithDifferentSuit = new TwoCardsHand(new Card(Suit.DIAMONDS, Rank.SEVEN), new Card(Suit.CLUBS, Rank.QUEEN));

    TwoCardsHand handWithHigherRankingCard = new TwoCardsHand(new Card(Suit.CLUBS, Rank.KING), new Card(Suit.HEARTS, Rank.EIGHT));
    TwoCardsHand handWithLowerRankingCard = new TwoCardsHand(new Card(Suit.DIAMONDS, Rank.JACK), new Card(Suit.SPADES, Rank.ACE));

    TwoCardsHand notASpecialHand = new TwoCardsHand(new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.HEARTS, Rank.ACE));

    @Test
    public void testCompareForSameRanks() throws Exception {
        assertThat(HandComparison.compareForSameRanks(handWithSameRank, handWithDifferentRank), equalTo(handWithSameRank));
        assertThat(HandComparison.compareForSameRanks(handWithDifferentRank, handWithSameRank), equalTo(handWithSameRank));
    }

    @Test
    public void testCompareForSameSuit() throws Exception {
        assertThat(HandComparison.compareForSameSuit(handWithSameSuit, handWithDifferentSuit), equalTo(handWithSameSuit));
        assertThat(HandComparison.compareForSameSuit(handWithDifferentSuit, handWithSameSuit), equalTo(handWithSameSuit));
    }

    @Test
    public void testCompareHandsByHigherCardRanking() throws Exception {
        TwoCardsHand actualHigherRankingCard = HandComparison.compareHandsByHigherCardRanking(handWithHigherRankingCard, handWithLowerRankingCard);
        assertThat(actualHigherRankingCard, equalTo(handWithHigherRankingCard));

        actualHigherRankingCard = HandComparison.compareHandsByHigherCardRanking(handWithLowerRankingCard, handWithHigherRankingCard);
        assertThat(actualHigherRankingCard, equalTo(handWithHigherRankingCard));
    }

    @Test
    public void testFindWinningHandWithException() {
        exception.expect(IllegalArgumentException.class);
        TwoCardsHand secondHand = new TwoCardsHand(new Card(Suit.CLUBS, Rank.EIGHT), new Card(Suit.DIAMONDS, Rank.NINE));
        HandComparison.findWinningHand(null, secondHand);
    }

    @Test
    public void testFindWinningsWithSameRanksButDifferentSuits() throws Exception {
       assertThat(HandComparison.findWinningHand(handWithSameRank, notASpecialHand), equalTo(handWithSameRank));
    }

    @Test
    public void testFindWinningsWithDifferentRanksButSameSuits() throws Exception {
        assertThat(HandComparison.findWinningHand(handWithSameSuit, notASpecialHand), equalTo(handWithSameSuit));
    }

    @Test
    public void testFindWinningsWithDifferentDifferentRanksDifferentSuits() throws Exception {
        assertThat(HandComparison.findWinningHand(handWithHigherRankingCard, notASpecialHand), equalTo(handWithHigherRankingCard));
    }

}