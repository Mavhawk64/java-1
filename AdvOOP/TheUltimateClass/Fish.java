package TheUltimateClass;
import java.util.Scanner;
/**
 * Write a class that uses the principles of Encapsulation and meets all of the following criteria:
 * 1. Has at least three instance variables with access modifiers.
 * 2. Sets all instance variables to generic values in a default constructor.
 * 3. Uses an overloaded constructor to set the instance variables to specific values.
 * 4. Uses the word this to refer to variables of the class
 * 5. Makes use of an overloaded method.
 * 6. Has at least one static variable and static method.
 * 7. Uses at least one getter and setter to control access to a private variable.
 * 8. Uses at least 5 “blue comments” which will add developer notes to the documentation.
 * 9. Uses at least 3 single line comments to make quick notes about various functionality
 * 10. Create a “runner” class to test overloaded methods, constructors, static variables, and
 * getters/setters.
 * 
 * @author Maverick Berkland
 * @version 12 January, 2018
 */
public class Fish
{
    //Instance Variables...
    public boolean beautiful;
    private String fishType;
    private String skinColor;
    private boolean isSalty;
    public static int saltyfishPop = 0;
    public static int freshfishPop = 0;
    Fish()
    {
        beautiful = true;
    }

    Fish(boolean isSalty) //For Example - Fish in a Fish Tank
    {
        if(isSalty)
            saltyfishPop++;
        else
            freshfishPop++;
    }

    Fish(boolean isSalty, String skinColor, String fishType)
    {
        if(isSalty)
            saltyfishPop++;
        else
            freshfishPop++;

        this.skinColor = skinColor;
        this.fishType = fishType;
    }

    /**
     * This method will make a simple circular bubble
     */
    public void makeBubble()
    {
        System.out.println("                   ︵");
        System.out.println("                  (  )");
        System.out.println("                   ︶");
        System.out.println("      /\\     *Glub* *Glub*");
        System.out.println("|\\   /  \\");
        System.out.println("| \\ /   *\\");
        System.out.println("|  >      <");
        System.out.println("| / \\    /");
        System.out.println("|/   \\  /");
        System.out.println("      \\/");
        //This creates a fish
    }

    /**
     * The Getter
     * @return String skinColor
     */
    public String getColor ()
    {
        return this.skinColor;
    }

    /**
     * The Setter
     * @param String skinColor
     */
    public void setColor(String skinColor)
    {
        this.skinColor = skinColor;
    }

   
    /**
     * The Getter
     * @return String fishType
     */
    public String getType()
    {
        return this.fishType;
    }

    /**
     * The Setter
     * @param String fishType
     */
    public void setType (String fishType)
    {
        this.fishType = fishType;
    }
    
    /**
     * Static method for deaths of fish
     */
    public static void minusFreshPop()
    {
        freshfishPop--;
        System.out.println("There are now " + freshfishPop + " fresh fish left");
    }
    
    /**
     * Static method for deaths of fish
     */
    public static void minusSaltPop()
    {
        saltyfishPop--;
        System.out.println("There are now " + saltyfishPop + " salty fish left");
    }
}
