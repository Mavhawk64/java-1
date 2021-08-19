// COURSE: CSCI1620
// TERM: FALL 2020
//
// NAME: Maverick Berkland and Abdoul Latoundji
// RESOURCES: N/A

package snake;

/**
 * This is the first homework in CSCI1620.
 * 
 * This class is the Item class for the Snake game.
 * 
 * @author mberkland, abdoullatoundji
 *
 */
public class Item
{
    /**
     * item0 is the default value of Item X and Y coordinate.
     */
    public static final int item0 = 25;
    /**
     * x and y are the coordinate of the item/apple/mouse.
     */
    private int x, y;
    /**
     * The default constructor for an Item.
     * It sets the default location of the Item at position 25,25.
     */
    public Item()
    {
        x = item0;
        y = item0;
    }

    /**
     * The specific constructor for an Item. It sets the locaiton of the Item using the passed in parameters.
     * @param itemXIn - the supposed starting X value for the Item.
     * @param itemYIn - the supposed starting Y value for the Item.
     */
    public Item(int itemXIn, int itemYIn)
    {
        x = itemXIn;
        y = itemYIn;
    }

    /**
     * Returns the current X value for the Item.
     * @return The current X value for the Item.
     */
    public int getX()
    {
        //System.out.println("RETURNING X: " + x);
        return x; 
    }

    /**
     * Returns the current Y value for the Item.
     * @return The current Y value for the Item.
     */
    public int getY()
    {
        //System.out.println("RETURNING Y: " + y);
        return y; 
    }

    /**
     * Sets a new location for the item as long as both values are valid (>=0).
     * @param itemXIn - the supposed new X value for the Item.
     * @param itemYIn - the supposed new Y value for the Item.
     */
    public void setNewLocation(int itemXIn, int itemYIn)
    {
        x = itemXIn;
        y = itemYIn;
    }

    /**
     * Returns a String representing the item.
     * @return The String representation of the Item where X and Y are the item's X and Y values respectively.
     */
    @Override
    public String toString()
    {
        return String.format("The item is located at position (%s, %s)", getX(), getY());
    }
}
