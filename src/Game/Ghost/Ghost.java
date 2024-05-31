package Game.Ghost;

import Game.Entity;

import java.util.Random;

public class Ghost extends Entity implements Runnable {
    public boolean killable;
    public int ghostX = 0;
    public int ghostY = 0;
    public int[][] map = new int[][]{};
    public Ghost(int x, int y, int[][] map) {
        super(x, y);
        this.ghostX = x;
        this.ghostY = y;
        this.map = map;
    }

    public void move() {
        Random random = new Random();
        int direction = random.nextInt(4);
        switch (direction) {
            case 0 -> {
                if (ghostY > 0 && map[ghostY - 1][ghostX] != 1) {
                    ghostY--;
                }
            }
            case 1 -> {
                if (ghostY < map.length - 1 && map[ghostY + 1][ghostX] != 1) {
                    ghostY++;
                }
            }
            case 2 -> {
                if (ghostX > 0 && map[ghostY][ghostX - 1] != 1) {
                    ghostX--;
                }
            }
            case 3 -> {
                if (ghostX < map[0].length - 1 && map[ghostY][ghostX + 1] != 1) {
                    ghostX++;
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            move();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}