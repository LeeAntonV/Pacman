package Game;

import Game.Ghost.*;
import Game.Pacman.Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {
    private final static int[][] map = CreateMap.createMap();
    private static final int tileSize = 56;

    public int score = 0;
    GameOver gameOver = new GameOver();
    public JFrame frame = null;
    Pacman pacman = new Pacman(7,7, tileSize, map);
    Blinky blinky = new Blinky(6,5, tileSize, map);
    Inky inky = new Inky(8, 5, tileSize, map);
    Clyde clyde = new Clyde(8, 5, tileSize, map);
    Pinky pinky = new Pinky(7,5, tileSize, map);
    Ghost[] ghosts = new Ghost[4];
    Dot[] dots = new Dot[0];
    int lifes = 0;
    int ghostChangeCount = 0;
    public double seconds = 0;

    public GamePanel(JFrame frame) {
        setFocusable(true);
        pacman.getRightImage();

        this.score = 0;
        this.frame = frame;
        this.lifes = 3;
        this.seconds = 0;
        ghosts[0] = blinky;
        ghosts[1] = inky;
        ghosts[2] = clyde;
        ghosts[3] = pinky;

        new Thread(this).start();
        for (Ghost ghost: ghosts){
            new Thread(ghost).start();
        }
        fillDots();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_LEFT -> {
                        pacman.getLeftImage();
                        pacman.direction = Pacman.Direction.LEFT;
                    }
                    case KeyEvent.VK_RIGHT -> {
                        pacman.getRightImage();
                        pacman.direction = Pacman.Direction.RIGHT;
                    }
                    case KeyEvent.VK_UP -> {
                        pacman.getUpImage();
                        pacman.direction = Pacman.Direction.UP;
                    }
                    case KeyEvent.VK_DOWN -> {
                        pacman.getDownImage();
                        pacman.direction = Pacman.Direction.DOWN;
                    }
                }
            }
        });

    }

    boolean run = true;
    @Override
    public void run() {
        while (run) {
            seconds += 0.1;
            if (dots.length == 0){
                try{
                    Thread.sleep(300);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                restart();
            }
            if (blinky.killable || inky.killable){
                ghostChangeCount++;
                if (ghostChangeCount == 50){
                    for (Ghost ghost: ghosts){
                        ghost.killable = false;
                    }
                    ghostChangeCount = 0;
                }
            }
//            pacman.updatePacmanPosition();
            pacmanOnGhost();
            pacmanOnDot();
            if (pacman.idx == 3) {
                pacman.idx = 0;
            }
            pacman.idx += 1;
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        String scoreText = "Score: " + score;
        String lifesText =  "Lifes: " + lifes;
        String secondsText = "Seconds: " + (int)seconds;
        g.setColor(Color.WHITE);
        g.drawString(scoreText, 5*tileSize, 10*tileSize);
        g.drawString(lifesText, 3*tileSize, 10*tileSize);
        g.drawString(secondsText, 7*tileSize, 10*tileSize);
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 1) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                } else if (map[row][col] == 2) {
                    g.setColor(Color.CYAN);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize / 2);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                }
            }
        }
        blinky.draw(g2d, this);
        inky.draw(g2d, this);
        clyde.draw(g2d, this);
        pinky.draw(g2d, this);
        pacman.draw(g2d, this);
        for (Dot d: dots){
            d.draw(g2d, this);
        }
    }

    public void pacmanOnGhost(){
        for (Ghost ghost : ghosts) {
            if (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY && !ghost.killable) {
                try{
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if (lifes == 0) {
                    frame.dispose();
                    run = false;
                    gameOver.setVisible(true);
                    gameOver.score = score;
                    break;
                }
                lifes--;
                restart();
            } else if (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY && ghost.killable) {
                ghost.ghostX = 6;
                ghost.ghostY = 5;
                ghost.killable = false;
                score += 200;
            }
        }
    }

    public void pacmanOnDot(){
        for (Dot d: dots) {
            if (pacman.pacmanX == d.dotX && pacman.pacmanY == d.dotY){
                score += 100;
                dots = deleteDot(dots, d);
                if (d.special){
                    for (Ghost ghost : ghosts) {
                        ghost.killable = true;
                    }
                    ghostChangeCount = 0;
                }
            }
        }
    }

    public Dot[] deleteDot(Dot[] dots, Dot dot) {
        Dot[] newDots = new Dot[dots.length - 1];
        int index = 0;

        for (int i = 0; i < dots.length; i++) {
            if (dots[i] != dot) {
                newDots[index] = dots[i];
                index++;
            }
        }
        return newDots;
    }

    public Dot[] appendDot(Dot[] dots, Dot dot){
        Dot[] newDots = new Dot[dots.length + 1];
        for (int i = 0; i < dots.length; i++){
            newDots[i] = dots[i];
        }
        newDots[newDots.length - 1] = dot;
        return newDots;
    }

    public void fillDots(){
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (map[row][col] == 0) {
                    if (row == 1 && col == 1 || row == map.length - 2 && col == 1 || row == 1 && col == map[0].length - 2 || row == map.length - 2 && col == map[0].length - 2){
                        Dot dot = new Dot(col, row, tileSize, true);
                        dots = appendDot(dots, dot);
                        continue;
                    }
                    Dot dot = new Dot(col, row, tileSize, false);
                    dots = appendDot(dots, dot);
                }
            }
        }
    }

    public void restart(){
        fillDots();
        pacman.pacmanX = 7;
        pacman.pacmanY = 7;
        pacman.direction = Pacman.Direction.RIGHT;
        pacman.getRightImage();

        blinky.killable = false;
        blinky.ghostX = 6;
        blinky.ghostY = 5;

        pinky.killable = false;
        pinky.ghostX = 6;
        pinky.ghostY = 5;

        inky.killable = false;
        inky.ghostX = 8;
        inky.ghostY = 5;

        clyde.killable = false;
        clyde.ghostX = 7;
        clyde.ghostY = 5;
    }
}