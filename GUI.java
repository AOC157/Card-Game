package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;
    public static Card myCard;
    Game game;
    JButton button;
    JPanel playersCardPanel;
    JPanel buttonPanel;
    JButton you;
    JButton player1;
    JButton player2;
    JButton player3;


    public GUI(Game game) throws HeadlessException, InterruptedException {
        this.game = game;
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        createMyButtonList();

        createTurnCardsButton();
    }

    private void createTurnCardsButton() {
        playersCardPanel = new JPanel();
        playersCardPanel.setLayout(null);

        you = new JButton("you");
        player1 = new JButton("player1");
        player2 = new JButton("player2");
        player3 =  new JButton("player3");
        you.setBounds(205 , 240 , 70 ,40);
        player1.setBounds(400, 125 , 70 , 40);
        player2.setBounds(205, 10 , 70 , 40);
        player3.setBounds(10, 125 , 70 , 40);

        playersCardPanel.add(you);
        playersCardPanel.add(player1);
        playersCardPanel.add(player2);
        playersCardPanel.add(player3);

        add(playersCardPanel,BorderLayout.CENTER);
    }

    public JButton makeButton(String card) {
        JButton button = new JButton(card);
        ActionListener listener = new ButtonListener(card,buttonPanel,button);
        button.addActionListener(listener);
        return button;
    }

    public void createMyButtonList(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 7));
        for(int index = 0; index < game.you.playerCard.size(); index++) {
            button = makeButton(game.you.playerCard.get(index).convertCardToString());
            buttonPanel.add(button);
        }
        buttonPanel.setVisible(true);
        add(buttonPanel,BorderLayout.SOUTH);
    }

    public void setButtonsText(Player player, Card card) {
        String stringCard = card.convertCardToString();
        if(player.equals(game.you)){
            you.setText(stringCard);
        }
        if(player.equals(game.player1)){
            player1.setText(stringCard);
        }
        if(player.equals(game.player2)){
            player2.setText(stringCard);
        }
        if(player.equals(game.player3)){
            player3.setText(stringCard);
        }
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
