package Game.GameOver;
import HighScore.WriteScore;
import StartMenu.StartMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOver extends JFrame {
    public int score = 0;
    public GameOver() {
        setTitle("Game Over");

        setLocationRelativeTo(null);

        setSize(400, 300);

        setResizable(false);


        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setForeground(Color.YELLOW);
        panel.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel("Game Over! Type your name below to be in leaderboard!");
        messageLabel.setForeground(Color.YELLOW);
        panel.add(messageLabel, BorderLayout.NORTH);

        JTextField inputField = new JTextField(20);
        inputField.setForeground(Color.YELLOW);
        inputField.setSize(400, 50);
        inputField.setBackground(Color.GRAY);
        panel.add(inputField, BorderLayout.CENTER);

        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(getWidth(), 50));
        okButton.setBackground(Color.GREEN);
        panel.add(okButton, BorderLayout.SOUTH);

        add(panel);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                input.trim().replaceAll("\\s+", " ");
                dispose();
                if(!input.isEmpty()){
                    WriteScore.writeScore(input, score);
                }
                new StartMenu();
            }
        });

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
                new StartMenu();
            }
        });
    }
}
