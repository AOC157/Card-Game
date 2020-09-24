package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 270;
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
        createButtonList();
        playersCardPanel = new JPanel();

        start = new JButton("start");
        card1 = new JButton("card1");
        card2 = new JButton("card2");
        card3 = new JButton("card3");
        playersCardPanel.add(start,BorderLayout.SOUTH);
        playersCardPanel.add(card1,BorderLayout.EAST);
        playersCardPanel.add(card2,BorderLayout.NORTH);
        playersCardPanel.add(card3,BorderLayout.WEST);
        add(playersCardPanel,BorderLayout.CENTER);

    }

    public JButton makeButton(String card) {
        JButton button = new JButton(card);
        ActionListener listener = new ButtonListener(card,buttonPanel,button);
        button.addActionListener(listener);
        return button;
    }

    public void createButtonList(){
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 7));
        for(int index = 0; index < game.you.playerCard.size(); index++) {
            button = makeButton(game.you.playerCard.get(index).convertCardToString());
            buttonPanel.add(button);
        }
        buttonPanel.setVisible(true);
        add(buttonPanel,BorderLayout.SOUTH);
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
            panel.remove(button);
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
