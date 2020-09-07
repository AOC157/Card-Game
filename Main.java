package com.company;

public class Main {

    public static void main(String[] args) {
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

        while (true){
            Card start = game.turnKing.playTurn();
            int playerNumber = game.whoseTurn();
            Player momentPlayer = game.convertNumberToPlayer(playerNumber);
            Card card1 = momentPlayer.playTurn(start);
            momentPlayer = game.convertNumberToPlayer(playerNumber++);
            Card card2 = momentPlayer.playTurn(start, card1);
            momentPlayer = game.convertNumberToPlayer(playerNumber + 1);
            Card card3 = momentPlayer.playTurn(start, card1, card2);

            Player winner = game.defineWinner(game.turnKing,start,card1,card2,card3);
            winner.score++;

            if(game.finishCheck()) break;

            game.turnKing = winner;
        }

    }
}
