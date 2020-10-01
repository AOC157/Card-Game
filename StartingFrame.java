package com.company;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingFrame extends JFrame {
    private static final int FRAME_WIDTH = 370;
    private static final int FRAME_HEIGHT = 200;
    private static final Font FONT = new Font("Arial", Font.PLAIN, 16);
    public Game game;
    public ButtonGroup types;
    private static JRadioButton d;
    private static JRadioButton g;
    private static JRadioButton k;
    private static JRadioButton p;

    public StartingFrame(Game game) throws HeadlessException {
        this.game = game;
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        addMyCards();
        createTypes();
        createEnter();
    }

    private void addMyCards() {
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(), "your cards"));
        panel.setLayout(new GridLayout(1,5));
        for (int index = 0; index < game.you.playerCard.size(); index++){
            JButton card = new JButton(game.you.playerCard.get(index).convertCardToString());
            panel.add(card);
        }
        add(panel,BorderLayout.NORTH);
    }

    private void createEnter() {
        JButton enter = new JButton("Enter");
        ActionListener listener = new EnterListener(game);
        enter.addActionListener(listener);
        JPanel panel = new JPanel();
        panel.add(enter);
        add(panel,BorderLayout.SOUTH);
    }

    class EnterListener implements ActionListener{
        Game game;

        public EnterListener(Game game) {
            this.game = game;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(d.isSelected()){
                game.kingCard = 'd';
                dispose();
            }
            else if(g.isSelected()){
                game.kingCard = 'g';
                dispose();
            }
            else if(k.isSelected()){
                game.kingCard = 'k';
                dispose();
            }
            else if(p.isSelected()){
                game.kingCard = 'p';
                dispose();
            }
        }
    }

    private void createTypes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));
        types = new ButtonGroup();
        d = new JRadioButton("d");
        g = new JRadioButton("g");
        k = new JRadioButton("k");
        p = new JRadioButton("p");

        d.setFont(FONT);
        g.setFont(FONT);
        p.setFont(FONT);
        k.setFont(FONT);

        types.add(d);
        types.add(g);
        types.add(k);
        types.add(p);

        panel.add(d);
        panel.add(p);
        panel.add(g);
        panel.add(k);
        add(panel, BorderLayout.CENTER);
    }
}
