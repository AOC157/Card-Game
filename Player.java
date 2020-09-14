package com.company;

import java.util.ArrayList;
import java.util.Scanner;

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
    public Card playTurn() {
        Scanner scanner = new Scanner(System.in);
        int cardNumber = scanner.nextInt();
        char cardType = scanner.next().charAt(0);
        System.out.print('*');
        return new Card(cardType , cardNumber);
    }

    public Card playTurn(char kingCard,Card start,Card card1,Card card2) {
        if(!start.isBigger(card1,kingCard) && card1.isBigger(card2,kingCard)){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
            else{
                try {
                    Card card;
                    card = minOfAllCardsExceptKing(kingCard);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    return minOfAllCards();
                }
            }
        }
        Card bigger = (start.isBigger(card2,kingCard)) ? start : card2;
        boolean cut = (bigger.type == kingCard && start.type != kingCard);
        if(cut){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
            else {
                try{
                    Card card;
                    card = minCardInSameTypeBiggerThan(bigger);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    try {
                        Card card;
                        card = minOfAllCardsExceptKing(kingCard);
                        int nullTest = card.number;
                        return card;
                    }
                    catch (NullPointerException ne){
                        return minOfAllCards();
                    }
                }
            }
        }
        else{
            if(isThereType(start.type)){
                try {
                    Card card;
                    card = minCardInSameTypeBiggerThan(bigger);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    return minOfSpecialType(start.type);
                }
            }
            else {
                if(isThereType(kingCard)){
                    return minOfSpecialType(kingCard);
                }
            }
        }
        return minOfAllCards();
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
            try {
                if (card.number < min.number && card.type != kingCard) {
                    min = card;
                }
            }
            catch (NullPointerException n){
                return null;
            }
        }
        return min;
    }

    public Card playTurn(char kingCard,Card start,Card card1) {
        if(start.isBigger(card1,kingCard)){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
            else{
                try {
                    Card card;
                    card = minOfAllCardsExceptKing(kingCard);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    return minOfAllCards();
                }
            }
        }
        boolean cut = (card1.type == kingCard && start.type != kingCard);
        if(cut){
            if(isThereType(start.type)){
                return minOfSpecialType(start.type);
            }
            else if(isThereType(kingCard)){
                try {
                    Card card;
                    card = minCardInSameTypeBiggerThan(card1);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    return minOfAllCardsExceptKing(kingCard);
                }
            }
        }
        else{
            if(isThereType(start.type)){
                Card card;
                try {
                    card = minCardInSameTypeBiggerThan(card1);
                    int nullTest = card.number;
                    return card;
                }
                catch (NullPointerException n){
                    return minOfSpecialType(start.type);
                }
            }
            else{
                if(isThereType(kingCard)){
                    return minOfSpecialType(kingCard);
                }
            }
        }
        return minOfAllCards();
    }
    public Card playTurn(char kingCard,Card start) {
        Card card;
        if(isThereType(start.type)){
            try {
                card = minCardInSameTypeBiggerThan(start);
                int nullTest = card.number;
                return card;
            }
            catch (NullPointerException n){
                return minOfSpecialType(start.type);
            }
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
                min = new Card(card.type,card.number);
                break;
            }
        }
        for (Card card : playerCard){
            try {
                if (card.type == type && card.number < min.number) {
                    min = card;
                }
            }
            catch (NullPointerException n){
                return null;
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
        }
        return max;
    }
}
