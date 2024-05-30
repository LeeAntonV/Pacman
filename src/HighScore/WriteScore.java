package HighScore;

import java.io.FileWriter;
import java.io.IOException;

public class WriteScore {
    public static void writeScore(String name, int score) {
        try {
            FileWriter writer = new FileWriter("src/HighScore/scores.txt", true);
            String text = score + " " + name + "\n";
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
