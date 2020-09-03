package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Player you = new Player();
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        switch (game.declareHakem()){
            case 0:
                game.hakem = you;
                break;
            case 1:
                game.hakem = player1;
                break;
            case 2:
                game.hakem = player2;
                break;
            case 3:
                game.hakem = player3;
                break;
        }
    }
}
