package com.company;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        game.declareKingPlayer();

        game.giveCards(5);

        game.you.printAllCards();
        game.player1.printAllCards();
        game.player2.printAllCards();
        game.player3.printAllCards();

        game.declareKingCard();

        game.giveCards(8);

        game.you.printAllCards();
        game.player1.printAllCards();
        game.player2.printAllCards();
        game.player3.printAllCards();

        game.turnKing = game.kingPlayer;

        Card start;
        Card card1;
        Card card2;
        Card card3;

        GUI frame = new GUI(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        while (true){

            int playerNumber = game.numberOfPlayerAfterTurnKing();



            if(!game.you.equals(game.turnKing)) {
                start = game.turnKing.playTurn(game.kingCard);
                game.turnKing.deleteCard(start);
            }
            else{
                while (true){
                    sleep(200);
                    start = GUI.myCard;
                    if(start != null) break;
                }
                game.you.deleteCard(start);
            }
            frame.setButtonsText(game.turnKing , start);
            start.show();

            Player momentPlayer = game.convertNumberToPlayer(playerNumber);
            if(!game.you.equals(momentPlayer)){
                card1 = momentPlayer.playTurn(game.kingCard,start);
                momentPlayer.deleteCard(card1);

            }
            else{
                while (true){
                    sleep(200);
                    card1 = GUI.myCard;
                    if(card1 != null) break;
                }
                game.you.deleteCard(card1);
            }
            frame.setButtonsText(momentPlayer , card1);
            card1.show();

            momentPlayer = game.convertNumberToPlayer(++playerNumber);
            if(!game.you.equals(momentPlayer)){
                card2 = momentPlayer.playTurn(game.kingCard,start, card1);
                momentPlayer.deleteCard(card2);
            }
            else{
                while (true){
                    sleep(200);
                    card2 = GUI.myCard;
                    if(card2 != null) break;
                }
                game.you.deleteCard(card2);
            }
            frame.setButtonsText(momentPlayer , card2);
            card2.show();

            momentPlayer = game.convertNumberToPlayer(playerNumber + 1);
            if(!game.you.equals(momentPlayer)){
                card3 = momentPlayer.playTurn(game.kingCard,start, card1, card2);
                momentPlayer.deleteCard(card3);
            }
            else{
                while (true){
                    sleep(200);
                    card3 = GUI.myCard;
                    if(card3 != null) break;
                }
                game.you.deleteCard(card3);
            }
            frame.setButtonsText(momentPlayer , card3);
            card3.show();

            Player winner = game.defineWinner(game.turnKing,start,card1,card2,card3,game.kingCard);

            winner.score++;

            if(winner.equals(game.you) || winner.equals(game.player2)){
                System.out.print("your team won this turn");
            }
            else{
                System.out.print("your team lost this turn");
            }
            int myTeamScore = game.you.score + game.player2.score;
            int rivalScore = game.player1.score + game.player3.score;
            System.out.println("(* " + myTeamScore + "  :  " + rivalScore + ")");

            if(game.finishCheck()) {
                break;
            }

            game.turnKing = winner;

            game.you.printAllCards();
            game.player1.printAllCards();
            game.player2.printAllCards();
            game.player3.printAllCards();

            sleep(2000);

            GUI.myCard = null;


        }
    }
}
