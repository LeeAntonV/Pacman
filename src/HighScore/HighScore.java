package HighScore;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class HighScore extends JPanel implements Serializable {

    private JList<String> scoresList;
    private DefaultListModel<String> listModel;

    public HighScore() {
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        scoresList = new JList<>(listModel);
        scoresList.setForeground(Color.YELLOW);
        scoresList.setBackground(Color.BLACK);

        String score = readFile();
        String[] scores = score.split("\\n");
        Arrays.sort(scores, (s1, s2) -> {
            int score1 = Integer.parseInt(s1.split(" ")[0]);
            int score2 = Integer.parseInt(s2.split(" ")[0]);
            return Integer.compare(score2, score1);
        });

        for (String s : scores) {
            listModel.addElement(s);
        }

        JScrollPane scrollPane = new JScrollPane(scoresList);
        add(scrollPane, BorderLayout.CENTER);
    }

    private String readFile() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/HighScore/scores.txt")));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
