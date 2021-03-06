package com.company;

import javax.swing.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        game.declareKingPlayer();

        game.giveCards(5);

        if (game.kingPlayer.equals(game.you)) {
            StartingFrame start = new StartingFrame(game);
            start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            start.setResizable(false);
            start.setVisible(true);
            while (start.isDisplayable()) {
                sleep(200);
            }
        }
        else{
            game.declareKingCard();
        }

        game.giveCards(8);

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
                frame.myTurn.setText("it's your turn");
                while (true){
                    sleep(200);
                    start = GUI.myCard;
                    if(start != null) break;
                }
                frame.myTurn.setText("");
                game.you.deleteCard(start);
            }
            frame.setButtonsText(game.turnKing , start);

            Player momentPlayer = game.convertNumberToPlayer(playerNumber);
            if(!game.you.equals(momentPlayer)){
                card1 = momentPlayer.playTurn(game.kingCard,start);
                momentPlayer.deleteCard(card1);
            }
            else{
                frame.myTurn.setText("it's your turn");
                while (true){
                    sleep(200);
                    card1 = GUI.myCard;
                    if(card1 != null) break;
                }
                frame.myTurn.setText("");
                game.you.deleteCard(card1);
            }
            frame.setButtonsText(momentPlayer , card1);

            momentPlayer = game.convertNumberToPlayer(++playerNumber);
            if(!game.you.equals(momentPlayer)){
                card2 = momentPlayer.playTurn(game.kingCard,start, card1);
                momentPlayer.deleteCard(card2);
            }
            else{
                frame.myTurn.setText("it's your turn");
                while (true){
                    sleep(200);
                    card2 = GUI.myCard;
                    if(card2 != null) break;
                }
                frame.myTurn.setText("");
                game.you.deleteCard(card2);
            }
            frame.setButtonsText(momentPlayer , card2);

            momentPlayer = game.convertNumberToPlayer(playerNumber + 1);
            if(!game.you.equals(momentPlayer)){
                card3 = momentPlayer.playTurn(game.kingCard,start, card1, card2);
                momentPlayer.deleteCard(card3);
            }
            else{
                frame.myTurn.setText("it's your turn");
                while (true){
                    sleep(200);
                    card3 = GUI.myCard;
                    if(card3 != null) break;
                }
                frame.myTurn.setText("");
                game.you.deleteCard(card3);
            }
            frame.setButtonsText(momentPlayer , card3);

            Player winner = game.defineWinner(game.turnKing,start,card1,card2,card3,game.kingCard);

            winner.score++;

            frame.showWinner(winner);

            frame.updateScores();

            if(game.finishCheck()) {
                frame.finish();
                break;
            }

            game.turnKing = winner;

            sleep(4000);
            frame.setButtonsTextEmpty();

            frame.turnWinner.setText("");

            GUI.myCard = null;
        }
    }
}
