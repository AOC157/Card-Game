package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;
    private static final Font BIG_FONT = new Font("Arial", Font.PLAIN, 18);
    private static final Font SMALL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static Card myCard;
    Game game;
    JButton button;
    JPanel gamePanel;
    JPanel myCardPanel;
    JButton yourCard;
    JButton player1Card;
    JButton player2Card;
    JButton player3Card;
    JLabel you;
    JLabel player1;
    JLabel player2;
    JLabel player3;
    JLabel kingCard;
    JLabel scores;


    public GUI(Game game) throws HeadlessException {
        this.game = game;

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        createGamePanel();
    }

    private void createGamePanel() {
        gamePanel = new JPanel();
        gamePanel.setLayout(null);

        createMyButtonList();

        createTurnCardsButton();

        createLabels();

        add(gamePanel,BorderLayout.CENTER);
    }

    private void createLabels() {
        kingCard = new JLabel("king card is \"" + game.kingCard + "\" !");
        scores = new JLabel("YOU 0 : 0 COM");
        you = new JLabel("YOU");
        player1 = new JLabel("PLAYER1");
        player2 = new JLabel("PLAYER2");
        player3 = new JLabel("PLAYER3");

        kingCard.setFont(BIG_FONT);
        scores.setFont(SMALL_FONT);
        kingCard.setBounds(175, 110, 200 ,40);
        scores.setBounds(190, 150 , 200 ,40);
        you.setBounds(227 , 270, 70 ,40);
        player1.setBounds(408 , 155 , 70 ,40);
        player2.setBounds(213 , 40, 70 ,40);
        player3.setBounds(18 , 155 , 70 ,40);

        gamePanel.add(kingCard);
        gamePanel.add(scores);
        gamePanel.add(you);
        gamePanel.add(player1);
        gamePanel.add(player2);
        gamePanel.add(player3);
    }

    private void createTurnCardsButton() {
        yourCard = new JButton("you");
        player1Card = new JButton("player1");
        player2Card = new JButton("player2");
        player3Card =  new JButton("player3");
        yourCard.setBounds(205 , 240 , 70 ,40);
        player1Card.setBounds(400, 125 , 70 , 40);
        player2Card.setBounds(205, 10 , 70 , 40);
        player3Card.setBounds(10, 125 , 70 , 40);

        gamePanel.add(yourCard);
        gamePanel.add(player1Card);
        gamePanel.add(player2Card);
        gamePanel.add(player3Card);

    }

    public JButton makeButton(String card) {
        JButton button = new JButton(card);
        ActionListener listener = new ButtonListener(card,myCardPanel,button);
        button.addActionListener(listener);
        return button;
    }

    public void createMyButtonList(){
        myCardPanel = new JPanel();
        myCardPanel.setLayout(new GridLayout(2, 7));
        for(int index = 0; index < game.you.playerCard.size(); index++) {
            button = makeButton(game.you.playerCard.get(index).convertCardToString());
            myCardPanel.add(button);
        }
        myCardPanel.setVisible(true);
        add(myCardPanel,BorderLayout.SOUTH);
    }

    public void setButtonsText(Player player, Card card) {
        String stringCard = card.convertCardToString();
        if(player.equals(game.you)){
            yourCard.setText(stringCard);
        }
        if(player.equals(game.player1)){
            player1Card.setText(stringCard);
        }
        if(player.equals(game.player2)){
            player2Card.setText(stringCard);
        }
        if(player.equals(game.player3)){
            player3Card.setText(stringCard);
        }
    }

    public void setButtonsTextEmpty() {
        yourCard.setText("");
        player1Card.setText("");
        player2Card.setText("");
        player3Card.setText("");
    }

    public void updateScores() {
        int myTeamScore = game.you.score + game.player2.score;
        int rivalScore = game.player1.score + game.player3.score;
        scores.setText("YOU " + myTeamScore + " : " + rivalScore + " COM");
    }


    static class ButtonListener implements ActionListener{

        public String card;
        public JPanel panel;
        public JButton button;

        public ButtonListener(String card,JPanel panel,JButton button) {
            this.card = card;
            this.panel = panel;
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            button.setVisible(false);
            myCard = convertStingToCard(card);
            panel.repaint();
        }

        private Card convertStingToCard(String card) {
            char type = card.charAt(card.length() - 1);
            int number = Integer.parseInt(card.substring(0 , card.length() - 1));
            return new Card(type,number);
        }
    }
}
