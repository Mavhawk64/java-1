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
    generateMap();
  }
}
