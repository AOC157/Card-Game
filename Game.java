package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public Card hokm;
    public Player hakem;
    Player you = new Player();
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    public ArrayList<String> cards = new ArrayList<>();

    public Game() {
        int counter = 1;
        for (int number = 1; number <= 13; number++) {
            switch (counter) {
                case 1:
                    cards.add(number + "d");
                    break;
                case 2:
                    cards.add(number + "g");
                    break;
                case 3:
                    cards.add(number + "p");
                    break;
                case 4:
                    cards.add(number + "k");
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


    public void declareHakem() {
        Random random = new Random();
        int playerNumber = random.nextInt(4);
        switch (playerNumber) {
            case 0:
                this.hakem = this.you;
                break;
            case 1:
                this.hakem = this.player1;
                break;
            case 2:
                this.hakem = this.player2;
                break;
            case 3:
                this.hakem = this.player3;
                break;
        }
    }

}
