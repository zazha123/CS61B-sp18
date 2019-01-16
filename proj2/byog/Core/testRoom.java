package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 *  Draws a world that is mostly empty except for a small region.
 */
public class testRoom {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 50;
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
        int num = 0;
        for (int i=0; i < 29; i++) {
            /*
            //print Room num
            num++;
            System.out.print("num:");
            System.out.println(num);
            */
            Room rm = new Room(world);
            Room newroom=rm.addRoom(world);
            rm.drawRoom(newroom,world);
        }

        //
        // draws the world to the screen
        ter.renderFrame(world);
    }


}
