package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    public Card hokm;
    public Player hakem;
    public ArrayList <String> cards = new ArrayList<>();

    public Game() {
        int counter = 1;
        for(int number = 1; number <= 13; number++){
            switch (counter){
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
            if(number == 13){
                counter++;
                if(counter <= 4){
                    number = 0;
                }
            }
        }
        System.out.println(cards);
    }

    public int declareHakem(){
        Random random = new Random();
        return random.nextInt(4);
    }

}
