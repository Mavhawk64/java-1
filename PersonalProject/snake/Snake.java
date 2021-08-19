// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: N/A

package snake;

public class Snake
{
    int x, y;
    Direction cDir = Direction.DOWN;
    int xc, yc;
    int length = 4;
  	int [][] snake;
    /**
     * The default constructor for the Snake.
     * It should do the same as the specific constructor except that it will use the value of 20 as the Default value for both the X and Y values for the head as the parameters.
     */
    Snake()
    {
      x = 20;
      y = 20;
      snake = new int [5000][2];
      xc = 0;
      yc = 1;
    }

    /**
     * The specific constructor for the Snake.
     * The snake 2d array should be initialized with a size of [5000][2].
     * The snake should have its head's X and Y values set.
     * The snake should then form out of the head to an initial length of 4.
     * When forming out, this is the order that it should expand:
     * 1) Above the head; if no space to continue doing so
     * 2) Left of the head; if no space to continue doing so
     * 3) Below the head
     * We will not place the initial Snake too close to the
     * top left corner so that it cannot grow to its initial size.
     * The initial direction of the snake should be DOWN.
     * 
     * @param headXIn - - the initial X value for the head of the Snake.
     * @param headYIn - - the initial Y value for the head of the Snake.
     */
    Snake(int headXIn, int headYIn)
    {
        x = headXIn;
        y = headYIn;
      	snake = new int [5000][2];
      	xc = 0;
      	yc = 0;
      	if(cDir == Direction.UP)
             yc = -1;
        else if(cDir == Direction.LEFT)
            xc = -1;
        else if(cDir == Direction.RIGHT)
            xc = 1;
        else if(cDir == Direction.DOWN)
            yc = 1;
    }

    /**
     * Changes the Direction of the Snake, except if the new Direction is directly opposite of the current one.
     * @param dirIn - - the Direction that the Snake is trying to change to be facing
     */
    public void changeDir(Direction dirIn)
    {
        int tX = xc;
        int tY = yc;
        boolean e = false;
        xc = 0;
        yc = 0;
        if(getLength() < 2 || ((dirIn == Direction.DOWN && cDir != Direction.UP) || (dirIn == Direction.UP && cDir != Direction.DOWN) || (dirIn == Direction.LEFT && cDir != Direction.RIGHT) || (dirIn == Direction.RIGHT && cDir != Direction.LEFT)))
        {
            cDir = dirIn;
        }
        else
        {
            xc = tX;
            yc = tY;
            e = true;
        }

        if(!e)
        {
            if(cDir == Direction.UP)
                yc = -1;
            else if(cDir == Direction.LEFT)
                xc = -1;
            else if(cDir == Direction.RIGHT)
                xc = 1;
            else if(cDir == Direction.DOWN)
                yc = 1;
        }
    }

    /**
     * The current Direction of the Snake.
     * @return - The current Direction of the Snake.
     */
    public Direction getDirection()
    {
        return cDir;
    }

    /**
     * Returns the current X value for the head of the Snake.
     * @return - The current X value for the head of the Snake.
     */
    public int getHeadX()
    {
        return x;
    }

    /**
     * Returns the current Y value for the head of the Snake.
     * @return - The current Y value for the head of the Snake.
     */
    public int getHeadY()
    {
        return y;
    }
    /**
     * The current length value of the Snake.
     * @return - The current length value of the Snake.
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Returns the current Snake 2d array.
     * @return - The current Snake 2d array.
     */
    public int[][] getSnake()
    {
        return snake;
    }

    /**
     * Determines if the head of the Snake has hit another part of the Snake.
     * @return - true if the Snake hit itself
     */
    public boolean hitSelf()
    {
        return false;
    }

    /**
     * Increases the current length of the Snake and sets the newly added part of the tail as the current tail end value of the Snake.
     */
    public void increaseLength()
    {
        length++;
    }

    /**
     * The move method should move the Snake forward one space in the current Direction. HINT: Only the head will be in a "new" position, the rest will continue to follow the further up portions of the snake body.
     */
    public void move()
    {
        x+=xc;
        y+=yc;
    }
}
