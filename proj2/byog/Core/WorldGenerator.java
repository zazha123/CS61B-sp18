package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.util.Random;

import java.util.Random;
import java.util.ArrayList;

public class WorldGenerator{
    private TETile[][] world = null;
    private ArrayList<Hall> halls = new ArrayList<>();
    private String seed = null;
    private Random rng;

    private class Hall {
        private int xStart, yStart, xEnd, yEnd;
        private Room origin;

        public Hall(int xS, int yS, int xE, int yE) {
            this.xStart = xS;
            this.yStart = yS;
            this.xEnd = xE;
            this.yEnd = yE;
            // this.origin = r;
            halls.add(this);
        }

        /*
         * Hallway a a.draw();
         */
        private void draw() {
            fillArea(xStart, yStart, xEnd, yEnd, Tileset.FLOOR);
        }

        
        
    }
    private TETile getTile(int x, int y) {
        return world[x][y];
    }
    
    private void setTile(int x, int y, TETile tile) {
        world[x][y] = tile;
    }   
    
    private void fillArea(int startX, int startY, int endX, int endY, TETile tile) {
        int minX = Math.min(startX, endX);
        int minY = Math.min(startY, endY);
        int maxX = Math.max(startX, endX);
        int maxY = Math.max(startY, endY);
        for (int i = minX; i <= maxX; i += 1) {
            for (int j = minY; j <= maxY; j += 1) {
                setTile(i, j, tile);
            }
        }
    }

    public WorldGenerator() {
        world = new TETile[Game.WIDTH][Game.HEIGHT];
    }

    public TETile[][] getTheWorld() {
        return world;
    }

    public void addHall() {
        new Hall(1, 1, 5, 5).draw();
    }
    // 0 left 1 up 2 right 3 down   
    public void makeHall(int x, int y, int side) {
        if (x < 1 || x > Game.WIDTH || y < 1 || y > Game.HEIGHT) {
            return;
        }
        int currX = x;
        int currY = y;
        if (side == 0) {
            currX -= 1;
            while (currX > 2) {
                currX -= 1;
            }
            new Hall(currX, currY, x, y).draw();
        } else if (side == 1) {
            currY += 1;
            while (currY < Game.HEIGHT - 2) {
                currY += 1;
            }
            new Hall(currX, currY, x, y).draw();            
        } else if (side == 2) {
            currX += 1;
            while (currX < Game.WIDTH - 2) {
                currX += 1;
            }
            new Hall(currX, currY, x, y).draw();
        } else if (side == 3) {
            currY -= 1;
            while (currY > 2) {
                currY -= 1;
            }
            new Hall(currX, currY, x, y).draw();
        }

    }
    //draw a world with nothing
    public void drawEmptyWorld() {
        fillArea(0, 0, Game.WIDTH - 1, Game.HEIGHT - 1, Tileset.NOTHING);
    }
}
