package com.company;

import java.util.Random;

public class Game {
    public Card hokm;
    public Player hakem;

    public int declareHakem(){
        Random random = new Random();
        return random.nextInt(4);
    }

}
