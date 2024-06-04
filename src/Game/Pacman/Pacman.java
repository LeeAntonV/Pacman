package Game.Pacman;

import Game.Entity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Pacman extends Entity implements Runnable{
    public enum Direction{
        RIGHT,
        LEFT,
        UP,
        DOWN
    }

    private final int tileSize = 56;
    public Direction direction = Direction.RIGHT;
    public int[][] map = new int[][]{};
    private Image image;
    public int idx = 1;
    public int pacmanX = 0;
    public int pacmanY = 0;
    public int speed = 200;

    public Pacman(int x, int y, int tileSize, int[][] map) {
        super(x, y);
        pacmanX = x;
        pacmanY = y;
        this.map = map;
    }

    public void getUpImage(){
        try {
            if (this.idx == 1) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-up/1.png")));
            } else if (this.idx == 2) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-up/2.png")));
            } else if (this.idx == 3) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-up/3.png")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getRightImage(){
        try {
            if (this.idx == 1) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-right/1.png")));
            } else if (this.idx == 2) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-right/2.png")));
            } else if (this.idx == 3) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-right/3.png")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getLeftImage(){
        try {
            if (this.idx == 1) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-left/1.png")));
            } else if (this.idx == 2) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-left/2.png")));
            } else if (this.idx == 3) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-left/3.png")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void getDownImage(){
        try {
            if (this.idx == 1) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-down/1.png")));
            } else if (this.idx == 2) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-down/2.png")));
            } else if (this.idx == 3) {
                this.image = ImageIO.read(Objects.requireNonNull(getClass().getResource("pacman-down/3.png")));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void updatePacmanPosition() {
        switch (direction) {
            case LEFT -> {
                if (pacmanX > 0 && map[pacmanY][pacmanX - 1] == 0 || pacmanX>0 && map[pacmanY][pacmanX - 1] == 3) {
                    pacmanX--;
                } else if (pacmanX == 0) {
                    pacmanX = map[pacmanY].length - 1;
                }
            }
            case RIGHT -> {
                if (pacmanX < map[0].length - 1 && map[pacmanY][pacmanX + 1] == 0 || pacmanX < map[0].length - 1 && map[pacmanY][pacmanX + 1] == 3) {
                    pacmanX++;
                } else if (pacmanX == map[pacmanY].length - 1) {
                    pacmanX = 0;
                }
            }
            case UP -> {
                if (pacmanY > 0 && map[pacmanY - 1][pacmanX] == 0 || pacmanY > 0 && map[pacmanY - 1][pacmanX] == 3) {
                    pacmanY--;
                } else if (pacmanY == 0) {
                    pacmanY = map.length - 1;
                }
            }
            case DOWN -> {
                if (pacmanY < map.length - 1 && map[pacmanY + 1][pacmanX] == 0 || pacmanY > 0 && map[pacmanY + 1][pacmanX] == 3) {
                    pacmanY++;
                } else if (pacmanY == map.length - 1) {
                    pacmanY = 0;
                }
            }
        }
    }

    public JLabel drawImage(){
        switch (direction) {
            case RIGHT -> {
                getRightImage();
            }
            case LEFT -> {
                getLeftImage();
            }
            case UP -> {
                getUpImage();
            }
            case DOWN -> {
                getDownImage();
            }
        }
        ImageIcon icon = new ImageIcon(image);
        Image scaledImage = icon.getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(pacmanX*tileSize, pacmanY * tileSize, tileSize, tileSize);

        return label;
    }

    @Override
    public void run() {
        while(true) {
            updatePacmanPosition();
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
