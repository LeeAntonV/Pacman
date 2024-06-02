package StartMenu;

import Game.Game;
import HighScore.HighScoreWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseMap extends JFrame {
    public ChooseMap() {
        setTitle("Choose Map");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBackground(Color.BLACK);

        JButton tiny = new JButton("Tiny");
        tiny.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(tiny);

        JButton small = new JButton("Small");
        small.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(small);

        JButton medium = new JButton("Medium");
        medium.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(medium);

        JButton big = new JButton("Big");
        big.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(big);

        JButton huge = new JButton("Huge");
        huge.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(huge);

        tiny.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(1);
                game.setVisible(true);
                dispose();
            }
        });

        small.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(2);
                game.setVisible(true);
                dispose();
            }
        });

        medium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(3);
                game.setVisible(true);
                dispose();
            }
        });

        big.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(4);
                game.setVisible(true);
                dispose();
            }
        });

        huge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = new Game(5);
                game.setVisible(true);
                dispose();
            }
        });
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
