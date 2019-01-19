package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

/**
 * Draws a world that is mostly empty except for a small region.
 */
public class testWorldGenerator {
    private static final int WIDTH = 60;
    private static final int HEIGHT = 50;

    public static void main(String[] args) {
        WorldGenerator wg = new WorldGenerator();
        wg.drawEmptyWorld();
        wg.addHall();
        wg.makeHall(3, 4, 2);
        TETile[][] finalWorldFrame = wg.getTheWorld();
        TERenderer ter = new TERenderer();
        ter.initialize(Game.WIDTH - 50, Game.HEIGHT);
        ter.renderFrame(finalWorldFrame);
    }

}
