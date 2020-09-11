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
    public Card playTurn(char kingCard,Card start,Card card1,Card card2) {
        if(!start.isBigger(card1,kingCard) && card1.isBigger(card2,kingCard)){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
            else{
                return minOfAllCardsExceptKing(kingCard);
            }
        }
        Card bigger = (start.isBigger(card2,kingCard)) ? start : card2;
        if(isThereType(bigger.type)){
            return minOfSpecialType(bigger.type);
        }
        else if(isThereType(kingCard)){
            return minOfSpecialType(kingCard);
        }

        return minOfAllCardsExceptKing(kingCard);
    }

    private Card minOfAllCardsExceptKing(char kingCard) {
        Card min = null;
        for(Card card : playerCard){
            if(card.type != kingCard){
                min = card;
                break;
            }
        }
        for (Card card : playerCard){
            if(card.number < min.number && card.type != kingCard){
                min = card;
            }
        }
        return min;
    }

    public Card playTurn(char kingCard,Card start,Card card1) {
        if(start.isBigger(card1,kingCard)){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
        }
        else {
            if(isThereType(start.type)){
                return minCardInSameTypeBiggerThan(card1);
            }
            else if(isThereType(kingCard)){
                return minOfSpecialType(kingCard);
            }
        }
        return minOfAllCards();
    }
    public Card playTurn(char kingCard,Card start) {
        if(isThereType(start.type)){
            return minCardInSameTypeBiggerThan(start);
        }
        else if(isThereType(kingCard)){
            return minOfSpecialType(kingCard);
        }
        return minOfAllCards();
    }

    private Card minCardInSameTypeBiggerThan(Card start) {
        Card min = playerCard.get(0);
        for(Card card : playerCard){
            if(card.type == start.type && card.number > start.number){
                min = card;
            }
        }
        if(min.type == start.type){
            return min;
        }
        return null;
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
