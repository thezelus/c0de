package cardGame.util;

import cardGame.model.TwoCardsHand;

public class HandComparison {

    private HandComparison(){}

    public static TwoCardsHand findWinningHand(TwoCardsHand firstHand, TwoCardsHand secondHand){

        if(firstHand == null || secondHand == null)
            throw new IllegalArgumentException("Illegal arguments: null values");

        return compareForSameRanks(firstHand, secondHand);
    }

    static TwoCardsHand compareForSameRanks(TwoCardsHand firstHand, TwoCardsHand secondHand) {
        if(firstHand.hasSameRankCards() && !secondHand.hasSameRankCards())
            return firstHand;
        else if (!firstHand.hasSameRankCards() && secondHand.hasSameRankCards())
            return secondHand;
        else
            return compareForSameSuit(firstHand, secondHand);
    }

    static TwoCardsHand compareForSameSuit(TwoCardsHand firstHand, TwoCardsHand secondHand) {
        if(firstHand.hasSameSuiteCards() && !secondHand.hasSameSuiteCards())
            return firstHand;
        else if(!firstHand.hasSameSuiteCards() && secondHand.hasSameSuiteCards())
            return secondHand;
        else
            return compareHandsByHigherCardRanking(firstHand, secondHand);
    }

    static TwoCardsHand compareHandsByHigherCardRanking(TwoCardsHand firstHand, TwoCardsHand secondHand) {
        int firstHandFaceValue = firstHand.getHigherRankingCardInTheHand().getRank().getFaceValue();
        int secondHandFaceValue = secondHand.getHigherRankingCardInTheHand().getRank().getFaceValue();

        if(firstHandFaceValue >= secondHandFaceValue)
            return firstHand;
        else
            return secondHand;
    }

}
