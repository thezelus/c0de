package cardGame.model;

import cardGame.exceptions.EmptyDeckException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class DeckTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testDrawTopCardEmptyDeckException() throws Exception {

        Deck testDeck = new Deck();
        for(int i = 0; i < 52; i++)
            testDeck.drawTopCard();

        exception.expect(EmptyDeckException.class);
        testDeck.drawTopCard();
    }

    @Test
    public void testHasNextCard() throws Exception {

        Deck testDeck = new Deck();
        assertThat(testDeck.hasNextCard(), equalTo(true));

        for(int i = 0; i < 52; i++)
            testDeck.drawTopCard();

        assertThat(testDeck.hasNextCard(), equalTo(false));
    }
}