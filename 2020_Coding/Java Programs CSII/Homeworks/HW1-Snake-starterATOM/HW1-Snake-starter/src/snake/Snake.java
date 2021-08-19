// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: N/A

package snake;

/**
Access to all of the following:

changeDir(Direction) - Changes the Direction of the Snake, except if
the new Direction is directly opposite of the current one. (Snake)

generateMap() - Generates the 2-dimensional map of the game area. (Level)

getDirection() - The current Direction of the Snake. (Snake)

getGameState() - Returns the current GameState. (Level)

getHeadX() - Returns the current X value for the head of the Snake. (Snake)
getHeadY() - Returns the current Y value for the head of the Snake. (Snake)

getItem() - Returns the current Item. (Level)

getLength() - The current length value of the Snake. (Snake)

getMap() - returns the current 2d array map. (level)

getSnake() - returns the current Snake. (Level)

getSnake() - returns the current Snake 2d array. (Snake)

getX(), getY() - returns x, y value for Item (Item)

hitSelf() - Determines if the head of the snake has hit
another part of the snake. (Snake)

increaseLength() - Increases the current length of the Snake
and sets the newly added part of the tail at the end of
the snake. (Snake)

Item() - Constructor for Item. (Item)
Item(int, int) - Constructor for Item with two int parameters. (Item)

Level(int, int, Random) - Creates a default
level with a given dimesnion. (Level)

LOST - Represents when the user has lost the game by allowing
the ball to go off-screen.

move() - The move method should move the Snake forward one
space in the current Direction. (Snake)

setNewLocation(int, int) - Sets a new location for the item as
long as both values are valid (>=0). (Item)

Snake() - The default constructor for the Snake. (Snake)
Snake(int, int) - Constructor for Snake with two
int parameters. (Snake)

updateOneStep() - Updates a single step. (Level)

*/

public class Snake
{
  Snake()
  {

  }

  Snake(int x, int y) //Initial positions of the headX and headY
  {

  }
}
