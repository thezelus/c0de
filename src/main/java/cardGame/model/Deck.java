package cardGame.model;

import cardGame.exceptions.EmptyDeckException;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        cards = Lists.newArrayList();
        for(Suit suit :Suit.values()){
            for(Rank rank : Rank.values()){
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card drawTopCard() throws EmptyDeckException {
        if(cards.isEmpty())
            throw new EmptyDeckException("No cards available in the deck");
        else
            return cards.remove(0);
    }

    public boolean hasNextCard(){
        return cards.size() > 0;
    }
}
