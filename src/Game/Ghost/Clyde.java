package Game.Ghost;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Clyde extends Ghost {
    public int tileSize = 0;
    public Clyde(int x, int y, int tileSize, int[][] map) {
        super(x, y, map);
        this.killable = false;
        this.tileSize = tileSize;
        setImage();
    }

    public Image defaultImage = null;
    public Image blueImage = null;

    private void setImage() {
        try {
            this.defaultImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("clyde.png")));
            this.blueImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("blue_ghost.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JLabel drawImage(){
        if (!this.killable){
            ImageIcon icon = new ImageIcon(defaultImage);
            Image scaledImage = icon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            JLabel label = new JLabel(scaledIcon);
            label.setBounds(ghostX*tileSize, ghostY * tileSize, tileSize, tileSize);

            return label;
        }

        ImageIcon icon = new ImageIcon(blueImage);
        Image scaledImage = icon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(ghostX*tileSize, ghostY * tileSize, tileSize, tileSize);

        return label;
    }
}
