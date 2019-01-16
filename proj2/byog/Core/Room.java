package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.util.Random;

public class Room {
    private int length;
    private int width;
    private int xPos;
    private int yPos;
    private static final int L = 10;
    private static final int W = 8;
    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    public Room(TETile[][] world) {
        length = RANDOM.nextInt(L) + 1; // length [1, L]
        width = RANDOM.nextInt(W) + 1; //  width  [1, W]
        xPos = RANDOM.nextInt(world.length - length - 1);//     xPos [0, world length - (length + 2)]
        yPos = RANDOM.nextInt(world[0].length - width - 1);//   yPos [0, world width - (width + 2)]
    }

    public boolean isOverlap(Room r, TETile[][] world) {
        for (int i = r.length + 1; i >= 0; i--) {
            for (int j = r.width + 1; j >= 0; j--) {
                //  scan the Room coverage from upper right corner to check if it overlaps with any existing room
                if (world[r.xPos + i][r.yPos + j] != Tileset.NOTHING) {
                    return true;
                }
            }
        }
        return false;
    }

    public Room addRoom(TETile[][] world) {
        Room room = new Room(world);
        while(isOverlap(room, world)) {
            room = new Room(world);
        }
        /*
        //print Room parameters
        System.out.print("l:");
        System.out.println(room.length);
        System.out.print("w:");
        System.out.println(room.width);
        System.out.print("x:");
        System.out.println(room.xPos);
        System.out.print("y:");
        System.out.println(room.yPos);
        */
        return room;
    }

    public void drawRoom(Room r, TETile[][] world) {
        //Set upper & bottom Wall
        for (int i = 0; i < r.length + 2; i++) {
            world[r.xPos + i][r.yPos] = Tileset.WALL;
            world[r.xPos + i][r.yPos + r.width + 1] = Tileset.WALL;
        }
        //Set left & right Wall
        for (int j = 0; j < r.width; j++) {
            world[r.xPos][r.yPos + j + 1] = Tileset.WALL;
            world[r.xPos + r.length + 1][r.yPos + j + 1] = Tileset.WALL;
        }
        //Set floor
        for (int k = 0; k < r.length; k++) {
            for (int l = 0; l < r.width; l++) {
                world[r.xPos + 1 + k][r.yPos + 1 + l] = Tileset.FLOOR;
            }
        }
    }
}
