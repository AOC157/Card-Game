package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartingFrame extends JFrame {
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    public Game game;
    public ButtonGroup types;
    private static JRadioButton d;
    private static JRadioButton g;
    private static JRadioButton k;
    private static JRadioButton p;

    public StartingFrame(Game game) throws HeadlessException {
        this.game = game;
        setSize(FRAME_WIDTH,FRAME_HEIGHT);

        createTypes();
        createEnter();
    }

    private void createEnter() {
        JButton enter = new JButton("Enter");
        ActionListener listener = new EnterListener(game);
        enter.addActionListener(listener);
        JPanel panel = new JPanel();
        enter.setBounds(50,100 ,40,10);
        panel.add(enter);
        add(panel);
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

        types.add(d);
        types.add(g);
        types.add(k);
        types.add(p);

        panel.add(d);
        panel.add(p);
        panel.add(g);
        panel.add(k);
        add(panel, BorderLayout.NORTH);
    }
}
