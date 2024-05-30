package Game;

import Game.Ghost.Blinky;
import Game.Ghost.Ghost;
import Game.Ghost.Inky;
import Game.Pacman.Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {
    private final static int[][] map = CreateMap.createMap();
    private static final int tileSize = 56;
    private int ghostCount = 0;

    GameOver gameOver = new GameOver();
    public JFrame frame = null;
    Pacman pacman = new Pacman(7,7, tileSize);
    Blinky blinky = new Blinky(6,5, tileSize);
    Inky inky = new Inky(8, 5, tileSize);
    Ghost[] ghosts = new Ghost[2];
    Dot[] dots = new Dot[0];
    int lifes = 0;

    public GamePanel(JFrame frame) {
        setFocusable(true);
        pacman.getRightImage();


        this.frame = frame;
        ghosts[0] = blinky;
        ghosts[1] = inky;

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
            if (dots.length == 0){
                try{
                    Thread.sleep(300);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                restart();
            }
            pacman.updatePacmanPosition();
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
        pacman.draw(g2d, this);
        for (Dot d: dots){
            d.draw(g2d, this);
        }
    }

    public void pacmanOnGhost(){
        for (Ghost ghost : ghosts) {
            if (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY && !ghost.killable) {
                if (lifes == 0) {
                    frame.dispose();
                    run = false;
                    gameOver.setVisible(true);
                    break;
                }
                lifes--;
                try{
                    Thread.sleep(300);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                restart();
            } else if (pacman.pacmanX == ghost.ghostX && pacman.pacmanY == ghost.ghostY && ghost.killable) {
                ghost.ghostX = 6;
                ghost.ghostY = 5;
                ghost.killable = false;
            }
            if (ghostCount == 5){
                ghost.move(map);
                ghostCount = 0;
            }
            ghostCount++;
        }
    }

    public void pacmanOnDot(){
        for (Dot d: dots) {
            if (pacman.pacmanX == d.dotX && pacman.pacmanY == d.dotY){
                dots = deleteDot(dots, d);
                if (d.special){
                    for (Ghost ghost : ghosts) {
                        ghost.killable = true;
                    }
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
                    if (row == 3 && col == 0 || row == 4 && col == 0 || row == 5 && col == 0 || row == 3 && col == map[row].length - 1 || row == 4 && col == map[row].length - 1 || row == 5 && col == map[row].length - 1 || row == 5 && col == 6 || row == 5 && col == 7 || row == 5 && col == 8) {
                        continue;
                    }
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
        blinky.ghostX = 6;
        blinky.ghostY = 5;
        inky.ghostX = 8;
        inky.ghostY = 5;
        blinky.killable = false;
        inky.killable = false;
    }
}
