package Game;
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

        JLabel messageLabel = new JLabel("Game Over");
        messageLabel.setForeground(Color.YELLOW);
        panel.add(messageLabel);

        JTextField inputField = new JTextField(20);
        inputField.setPreferredSize(new Dimension(getWidth(), 20));
        panel.add(inputField);

        JButton okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(getWidth(), 50));
        okButton.setBackground(Color.GREEN);
        panel.add(okButton);

        add(panel);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                input.trim().replaceAll("\\s+", " ");
                dispose();
                if(!input.isEmpty()){
                    System.out.println("User input: " + input);
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
