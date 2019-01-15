package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 *  Draws a world that is mostly empty except for a small region.
 */
public class Draw {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static void addHexagon(TETile[][] world, int xPos, int yPos, int length) {
        int oddChange1 = (length + 1) % 2 ;                           /* the middle length and the middle position vary between odd and even */
        int oddChange2 = length % 2; 
        // draw down right  1/4
        int cur_length = length / 2 + length - 1 + oddChange2;                 /* the middle length of the hexagon */
        for (int y = yPos - 1; y > yPos - length -1; y -= 1) {
            for (int x = xPos; x < xPos + cur_length; x += 1) {
                world[x][y] = Tileset.WALL;
            }
            cur_length -= 1;
        }
        // draw down left  1/4
        cur_length = length / 2 + length - 1 + oddChange2;                 /* the middle length of the hexagon */
        for (int y = yPos - 1; y > yPos - length -1; y -= 1) {
            for (int x = xPos - oddChange1; x > xPos - cur_length - oddChange1; x -= 1) {
                world[x][y] = Tileset.WALL;
            }
            cur_length -= 1;
        }      
        // draw up left 1/4
        cur_length = length / 2 + length - 1 + oddChange2;                 /* the middle length of the hexagon */
        for (int y = yPos ; y < yPos + length; y += 1) {
            for (int x = xPos - oddChange1; x > xPos - cur_length - oddChange1; x -= 1) {
                world[x][y] = Tileset.WALL;
            }
            cur_length -= 1;
        }
        // draw up right 1/4
        cur_length = length / 2 + length - 1 + oddChange2;                 /* the middle length of the hexagon */
        for (int y = yPos ; y < yPos + length; y += 1) {
            for (int x = xPos; x < xPos + cur_length; x += 1) {
                world[x][y] = Tileset.WALL;
            }
            cur_length -= 1;
        }
    }

    public static void main(String[] args) {
        // initialize the tile rendering engine with a window of size WIDTH x HEIGHT
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        // initialize tiles
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        // draw one hexagon
        addHexagon(world, 10, 10, 4);

        // draws the world to the screen
        ter.renderFrame(world);
    }


}
