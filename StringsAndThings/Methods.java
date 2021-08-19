import java.util.Scanner;
/**
 * Maverick Berkland
 * Learning about String Methods
 * 11 September, 2017
 * Void Type
 * Return Type
 * Accepts A Value
 * One That Returns and Accepts
 */
public class Methods
{
    /**
     * THE VOID METHOD
     */
    public void SayHello ()
    {
        int x = 5; //Local Variable
        x = x + 5; //Not Available Outside Of Method
        System.out.println("Hello, x = " + x);
    }

    /**
     * THE STATIC VOID METHOD
     */
    public static void SayHelloStatic ()
    {
        int x = 5; //Local Variable
        x = x + 5; //Not Available Outside Of Method
        System.out.println("Hello, x = " + x);
    }

    /**
     * The Return Method
     */
    public int Numbers ()
    {
        int x = 45;
        return (x+1)-(6/3)*(2);
    }

    /**
     * Parameter Method
     */
    public void MakeExciting (String word)
    {
        word = word + "!";
        System.out.println(word);
    }
    
    /**
     * Both Returns and Accepts in Parameters
     */
    public int Power(int x, int y)
    {
        int z = x;
        for(int i = 1; i < y; i++)
        {
            x = x*z;
        }
        return x;
    }
    
    public String test(int x, int y, String z, char [] u, Scanner scan)
    {
        //Can only return one thing
        int f = x + y;
        return "NOTHING";
    }
    
    
    
}
