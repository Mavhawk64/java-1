// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: N/A

package snake;

import java.util.Random;

public class Level
{
    private int [][] grid;
    Level(int gW, int gH, Random r) //Width = 500, Height = 550, gW = 50, gH = 55
    {
        grid = new int[gW][gH]; //[50][55]
    }

    int[][] generateMap()
    {
        /*
         * Generates the 2-dimensional map of the game area.
         * Please read the supplemental document on the
         * differences between how the game map should look
         * vs the Snake. The following pattern should be used
         * for the map: 
         * If the space is open, place a 0 in that place in the map
         * If the space is occupied by the Snake, place a 1 in that place in the map
         * If the space is occupied by the Item, place a -1 in that place in the map
         */
        return grid;
    }

    GameState getGameState()
    {
        return null; 
    }

    Item getItem()
    {
        return null;
    }

    int[][] getMap()
    {
        return grid;
    }

    Snake getSnake()
    {
        return null;
    }
    
    void updateOneStep()
    {
        /*
         * Updates a single step.
         * The algorithm you use should go as follows:
         * 1) Move the Snake in its current direction
         * 2) Determine if a losing condition has been met
         *  (the Snake hitting itself or a wall)
         * 3) Determine if the Item has been grabbed by the Snake.
         * If it has, generate the new position for the Item.
         * If the position generated is currently being occupied by the Snake,
         * regenerate another position and check again.
         * Do this until a valid position has been found.
         * If the Item was grabbed, be sure to increase the length of the Snake as well.
         */
    }
}
