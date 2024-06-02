package Game.Dot;

import Game.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Dot extends Entity {
    public int dotX = 0;
    public int dotY = 0;
    public int tileSize = 0;
    public boolean special = false;
    public Image image = null;
    public Dot(int x, int y, int tileSize, boolean special) {
        super(x,y);
        this.dotX = x;
        this.dotY = y;
        this.tileSize = tileSize;
        this.special = special;
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("dot.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g, JPanel panel) {
        if (this.special) {
            g.drawImage(image, this.dotX * tileSize - 25, this.dotY * tileSize - 25, tileSize + 50, tileSize + 50, panel);
            return;
        }
        g.drawImage(image, this.dotX * tileSize , this.dotY * tileSize , tileSize, tileSize, panel);
    }
}
