package com.company;

import java.util.ArrayList;
import java.util.Collections;

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
    public Card playTurn(char kingCard,Card start) {
        ArrayList<Integer> difference = new ArrayList<>();
        if(isThereType(start.type)){
            for(Card card : playerCard){
                if(card.type == start.type){
                    difference.add(card.number - start.number);
                }
            }
            Collections.sort(difference);
            if(difference.get(0) < 0){
                return minOfSpecialType(start.type);
            }
        }
        else if(isThereType(kingCard)){
            return minOfSpecialType(kingCard);
        }
        return minOfAllCards();
    }

    private Card minOfAllCards() {
        Card min = playerCard.get(0);
        for (Card card : playerCard){
            if(card.number < min.number){
                min = card;
            }
        }
        return min;
    }

    private boolean isThereType(char type) {
        for(Card card : playerCard){
            if(card.type == type){
                return true;
            }
        }
        return false;
    }

    public Card playTurn(char kingCard) {
        if(allCardsIsKing(kingCard)){
            return minOfSpecialType(kingCard);
        }
        ArrayList<Card> noKingCards = new ArrayList<>();
        for(Card card : playerCard){
            if(card.type != kingCard){
                noKingCards.add(card);
            }
        }
        return maxOfNoKingCards(noKingCards);
    }

    private Card minOfSpecialType(char type) {
        Card min = null;
        for (Card card : playerCard){
            if(card.type == type){
                min = card;
                break;
            }
        }
        for (Card card : playerCard){
            if(card.type == type && card.number < min.number){
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
