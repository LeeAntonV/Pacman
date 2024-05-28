package StartMenu;

import HighScore.HighScoreWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {
    public StartMenu() {
        setTitle("Start Menu");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, with gaps
        panel.setBackground(Color.BLACK);

        JButton newGameButton = new JButton("New Game");
        newGameButton.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(newGameButton);

        JButton highScoresButton = new JButton("High Scores");
        highScoresButton.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(highScoresButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(getWidth(), 100));
        panel.add(exitButton);

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Starting New Game...");
            }
        });

        highScoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HighScoreWindow highScoreWindow = new HighScoreWindow();
                highScoreWindow.setVisible(true);
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }
}
