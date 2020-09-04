package com.company;

import java.util.ArrayList;

public class Player {
    ArrayList<Card> playerCard;

    public Player() {
        playerCard = new ArrayList<>();
    }

    public void printCard() {
        for(int index = 0; index < playerCard.size(); index++){
            System.out.print(playerCard.get(index).number + " " + playerCard.get(index).type + "***");
        }
        System.out.println();
    }
}
