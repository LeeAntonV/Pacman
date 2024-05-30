package Game;

import StartMenu.StartMenu;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public Game() {
        setTitle("Game");

        setSize(840, 600);

        setLocationRelativeTo(null);

        setResizable(false);

        GamePanel panel = new GamePanel(this);
        panel.setBackground(Color.BLACK);
        add(panel);

        Thread thread = new Thread(panel);
        thread.start();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new StartMenu();
                dispose();
            }
        });
    }
}
