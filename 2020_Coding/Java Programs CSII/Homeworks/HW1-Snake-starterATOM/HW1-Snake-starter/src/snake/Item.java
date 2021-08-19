// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: N/A

package snake;

public class Item
{
  // So... This item will be randomly generated in the world which is
  // 490x540 pixels large, which will need to be converted to an
  // array that is of size [49][54].
  // I have built many grids like this before, they are called
  // array-backed grids.
  // I am not entirely sure how they do this, but if we can, I would
  // do grid[][] = 0 (blank), 1 (snake), 2 (apple).
  Item()
  {
    int x = Level.r.newRandom().nextInt(0, 40);
    int y = Level.r.newRandom().nextInt(0, 54);
  }

  Item(int x, int y) //Initial position of food [x][y]
  {

  }
}
