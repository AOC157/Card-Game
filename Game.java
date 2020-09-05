package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public char kingCard;
    public Player kingPlayer;
    Player you = new Player();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    public ArrayList<Card> cards = new ArrayList<>();

    public Game() {
        int counter = 1;
        for (int number = 1; number <= 13; number++) {
            switch (counter) {
                case 1:
                    cards.add(new Card('d' , number));
                    break;
                case 2:
                    cards.add(new Card('g' , number));
                    break;
                case 3:
                    cards.add(new Card('p' , number));
                    break;
                case 4:
                    cards.add(new Card('k' , number));
                    break;
            }
            if (number == 13) {
                counter++;
                if (counter <= 4) {
                    number = 0;
                }
            }
        }
    }


    public void declareKingPlayer() {
        Random random = new Random();
        int playerNumber = random.nextInt(4);
        switch (playerNumber) {
            case 0:
                this.kingPlayer = this.you;
                break;
            case 1:
                this.kingPlayer = this.player1;
                break;
            case 2:
                this.kingPlayer = this.player2;
                break;
            case 3:
                this.kingPlayer = this.player3;
                break;
        }
        System.out.println("king is player" + playerNumber);
    }

    public void giveCards( int givenCardNumber) {
        Random random = new Random();
        int cardNumber = this.cards.size();
        int playerNumber = 0;
        for(int counter = 1; counter <= givenCardNumber; counter++){
            int index = random.nextInt(cardNumber);
            cardNumber--;
            switch (playerNumber) {
                case 0:
                    this.you.playerCard.add(this.cards.get(index));
                    break;
                case 1:
                    this.player1.playerCard.add(this.cards.get(index));
                    break;
                case 2:
                    this.player2.playerCard.add(this.cards.get(index));
                    break;
                case 3:
                    this.player3.playerCard.add(this.cards.get(index));
                    break;
            }
            this.cards.remove(index);
            if (counter == givenCardNumber) {
                playerNumber++;
                if (playerNumber <= 3) {
                    counter = 0;
                }
            }
        }
    }


    public void declareKingCard() {
        if(this.kingPlayer.equals(you)){
            Scanner scanner = new Scanner(System.in);
            kingCard = scanner.nextLine().charAt(0);
        }
        else{
            kingCard = declareKingCardForCom(kingPlayer.playerCard);
        }
        System.out.println("king card type is " + kingCard);
    }

    private char declareKingCardForCom(ArrayList<Card> playerCard) {
        int dType = 0;
        int gType = 0;
        int pType = 0;
        int kType = 0;
        for (Card card : playerCard) {
            switch (card.type) {
                case 'd':
                    dType++;
                    break;
                case 'g':
                    gType++;
                    break;
                case 'p':
                    pType++;
                    break;
                case 'k':
                    kType++;
                    break;
            }
        }
        int max1;
        int max2;
        char tempType1;
        char tempType2;

        if (dType != gType){
            max1 = Math.max(dType,gType);
            tempType1 = (max1 == dType)? 'd' : 'g';
        }
        else{
            tempType1 = maxNumber(playerCard,'d','g');
            max1 = (tempType1 == 'd')? dType : gType;
        }
        if(pType != kType){
            max2 = Math.max(pType,kType);
            tempType2 = (max1 == pType)? 'p' : 'k';
        }
        else{
            tempType2 = maxNumber(playerCard,'p','k');
            max2 = (tempType2 == 'p')? pType : kType;
        }
        if(max1 != max2){
            int finalMax = Math.max(max1,max2);
            return (finalMax == max1)? tempType1 : tempType2;
        }
        else {
            return maxNumber(playerCard,tempType1,tempType2);
        }
    }

    private char maxNumber(ArrayList<Card> playerCard, char alpha, char beta) {
        for (Card card : playerCard) {
            if (card.type == alpha && card.number == 1) {
                return alpha;
            }
            if (card.type == beta && card.number == 1) {
                return beta;
            }
            if (card.type == alpha && card.number == 13) {
                return alpha;
            }
            if (card.type == beta && card.number == 13) {
                return beta;
            }
            if (card.type == alpha && card.number == 12) {
                return alpha;
            }
            if (card.type == beta && card.number == 12) {
                return beta;
            }
            if (card.type == alpha && card.number == 11) {
                return alpha;
            }
            if (card.type == beta && card.number == 11) {
                return beta;
            }
            if (card.type == alpha && card.number == 10) {
                return alpha;
            }
            if (card.type == beta && card.number == 10) {
                return beta;
            }
            if (card.type == alpha && card.number == 9) {
                return alpha;
            }
            if (card.type == beta && card.number == 9) {
                return beta;
            }
            if (card.type == alpha && card.number == 8) {
                return alpha;
            }
            if (card.type == beta && card.number == 8) {
                return beta;
            }
            if (card.type == alpha && card.number == 7) {
                return alpha;
            }
            if (card.type == beta && card.number == 7) {
                return beta;
            }
            if (card.type == alpha && card.number == 6) {
                return alpha;
            }
            if (card.type == beta && card.number == 6) {
                return beta;
            }
            if (card.type == alpha && card.number == 5) {
                return alpha;
            }
            if (card.type == beta && card.number == 5) {
                return beta;
            }
            if (card.type == alpha && card.number == 4) {
                return alpha;
            }
            if (card.type == beta && card.number == 4) {
                return beta;
            }
        }
        return alpha;
    }
}
