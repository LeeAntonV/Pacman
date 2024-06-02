package Game;

import StartMenu.StartMenu;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    int height = 0;
    public Game(int mapSize) {
        setTitle("Game");
        int height = 0;

        if (mapSize == 1) {
            height = 600;
        } else if (mapSize == 2) {
            height = 700;
        } else if (mapSize == 3) {
            height = 800;
        } else if (mapSize == 4) {
            height = 930;
        } else if (mapSize == 5) {
            height = 1050;
        }
        setSize(840, height);

        setLocationRelativeTo(null);

        setResizable(false);

        GamePanel panel = new GamePanel(this, mapSize);
        panel.setBackground(Color.BLACK);
        add(panel);

        new Thread(panel).start();

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new StartMenu();
                dispose();
            }
        });
    }
}
