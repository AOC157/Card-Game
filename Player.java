package com.company;

import java.util.ArrayList;

public class Player {
    ArrayList<Card> playerCard;
    int score;

    public Player() {
        playerCard = new ArrayList<>();
        score = 0;
    }

    public void printAllCards() {
        for (Card card : playerCard) {
            System.out.print(card.number + " " + card.type + "***");
        }
        System.out.println();
    }

    public Card playTurn(char kingCard) {
        if(allCardsIsKing(kingCard)){
            return minOfKingCards();
        }
        ArrayList<Card> noKingCards = new ArrayList<>();
        for(Card card : playerCard){
            if(card.type != kingCard){
                noKingCards.add(card);
            }
        }
        return maxOfNoKingCards(noKingCards);
    }

    private Card minOfKingCards() {
        Card min = playerCard.get(0);
        for(Card card : playerCard){
            if(card.number < min.number){
                min = card;
            }
        }
        return min;
    }

    private boolean allCardsIsKing(char kingCard) {
        for(Card card : playerCard){
            if(card.type != kingCard){
                return false;
            }
        }
        return true;
    }

    private Card maxOfNoKingCards(ArrayList<Card> noKingCards) {
        Card max = noKingCards.get(0);
        for(Card card : noKingCards){
            if(card.number > max.number){
                max = card;
            }
            if(card.number == 1){
                return card;
            }
        }
        return max;
    }
}
