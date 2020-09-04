package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public Card kingCard;
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


}
