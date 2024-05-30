package Game.Ghost;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Pinky extends Ghost {
    public int tileSize = 0;
    public Pinky(int x, int y, int tileSize) {
        super(x, y);
        this.killable = false;
        this.tileSize = tileSize;
    }

    public Image defaultImage = null;
    public Image blueImage = null;

    private void setImage() {
        try {
            this.defaultImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("pinky.png")));
            this.blueImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("blue_ghost.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, JPanel panel) {
        setImage();
        if (!this.killable){
            g.drawImage(defaultImage, this.ghostX * tileSize, this.ghostY * tileSize, tileSize, tileSize, panel);
            return;
        }
        g.drawImage(blueImage, this.ghostX * tileSize, this.ghostY * tileSize, tileSize, tileSize, panel);
    }
}

