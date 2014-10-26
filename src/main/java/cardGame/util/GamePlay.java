package cardGame.util;

import cardGame.exceptions.EmptyDeckException;
import cardGame.model.Card;
import cardGame.model.Deck;
import cardGame.model.TwoCardsHand;

public class GamePlay {

    private GamePlay(){}

    public static void start() throws EmptyDeckException {

        Deck deckOfCards = new Deck();
        System.out.println("Creating a new deck of cards");

        deckOfCards.shuffle();
        System.out.println("Shuffling the deck");

        System.out.println("Drawing hands now \n");

        TwoCardsHand firstHand = new TwoCardsHand(deckOfCards.drawTopCard(), deckOfCards.drawTopCard());
        System.out.println("First hand " + firstHand.toString() + "\n");

        TwoCardsHand secondHand = new TwoCardsHand(deckOfCards.drawTopCard(), deckOfCards.drawTopCard());
        System.out.println("Second hand " + secondHand.toString() + "\n");

        System.out.println("Winning hand " + HandComparison.findWinningHand(firstHand, secondHand).toString());
    }

}
