package HighScore;

import StartMenu.StartMenu;

import javax.swing.*;
import java.awt.*;

public class HighScoreWindow extends JFrame {
    public HighScoreWindow() {
        setTitle("High Score");

        setSize(800, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        HighScore panel = new HighScore();
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.YELLOW);
        add(panel);

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new StartMenu();
                dispose();
            }
        });

        setVisible(true);
    }
}
