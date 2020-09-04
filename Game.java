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
        int dtype = 0;
        int gtype = 0;
        int ptype = 0;
        int ktype = 0;
        for (Card card : playerCard) {
            switch (card.type) {
                case 'd':
                    dtype++;
                    break;
                case 'g':
                    gtype++;
                    break;
                case 'p':
                    ptype++;
                    break;
                case 'k':
                    ktype++;
                    break;
            }
        }
        int max1 = Math.max(dtype,gtype);
        int max2 = Math.max(ptype,ktype);
        int finalMax = Math.max(max1,max2);

        if (finalMax == dtype){
            return 'd';
        }
        else if (finalMax == gtype){
            return 'g';
        }
        else if (finalMax == ptype){
            return 'p';
        }
        return 'k';


    }
}
