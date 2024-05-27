package StartMenu;

import javax.swing.*;

public class StartMenu extends JFrame {
    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class StartMenu extends JFrame {

        public StartMenu() {
            setTitle("Start Menu");

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setSize(400, 300);

            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            JButton newGameButton = new JButton("New Game");
            gbc.gridx = 0;
            gbc.gridy = 0;
            panel.add(newGameButton, gbc);

            JButton highScoresButton = new JButton("High Scores");
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(highScoresButton, gbc);

            JButton exitButton = new JButton("Exit");
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(exitButton, gbc);

            newGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Starting New Game...");
                }
            });

            highScoresButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Displaying High Scores...");
                }
            });

            // Add action listener for "Exit" button
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to exit the application
                    System.exit(0);
                }
            });

            add(panel);

            setVisible(true);
        }
}
