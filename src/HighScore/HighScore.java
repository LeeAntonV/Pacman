package HighScore;

import javax.swing.*;
import java.awt.Graphics;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class HighScore extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        String scores = readFile("src/HighScore/scores.txt");
        String[] score = scores.split("\\n");

        Arrays.sort(score, (s1, s2) -> {
            int score1 = Integer.parseInt(s1.split(" ")[0]);
            int score2 = Integer.parseInt(s2.split(" ")[0]);
            return Integer.compare(score2, score1);
        });

        int centerY = 50;
        int centerX = 350;
        for (String s : score) {
            g.drawString(s, centerX, centerY);
            centerY += 20;
        }
    }

    private String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
