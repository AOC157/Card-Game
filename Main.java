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

        Card start;
        Card card1;
        Card card2;
        Card card3;

        while (true){
            int playerNumber = game.numberOfPlayerAfterTurnKing();

            if(!game.you.equals(game.turnKing)) {
                start = game.turnKing.playTurn(game.kingCard);
                game.turnKing.playerCard.remove(start);
            }
            else{
                start = game.you.playTurn();
                game.you.deleteCard(start);
            }
            start.show();

            Player momentPlayer = game.convertNumberToPlayer(playerNumber);
            if(!game.you.equals(momentPlayer)){
                card1 = momentPlayer.playTurn(game.kingCard,start);
                momentPlayer.playerCard.remove(card1);
            }
            else{
                card1 = game.you.playTurn();
                game.you.deleteCard(card1);
            }
            card1.show();

            momentPlayer = game.convertNumberToPlayer(++playerNumber);
            if(!game.you.equals(momentPlayer)){
                card2 = momentPlayer.playTurn(game.kingCard,start, card1);
                momentPlayer.playerCard.remove(card2);
            }
            else{
                card2 = game.you.playTurn();
                game.you.deleteCard(card2);
            }
            card2.show();

            momentPlayer = game.convertNumberToPlayer(playerNumber + 1);
            if(!game.you.equals(momentPlayer)){
                card3 = momentPlayer.playTurn(game.kingCard,start, card1, card2);
                momentPlayer.playerCard.remove(card3);
            }
            else{
                card3 = game.you.playTurn();
                game.you.deleteCard(card3);
            }
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
        }
    }
}
