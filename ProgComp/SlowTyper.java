/**
 * This Class Prints Any String You Want In Slow Motion (1/2 second intervals). 
 *
 * @author Maverick 
 * @version 20 August, 2019
 */
public class SlowTyper
{
    public static void main()
    {
        String y = "Hello, I am Computer Buddy! This is in slow motion!";
        for(int i = 0; i < y.length(); i++)
        {
            try
            {
                Thread.sleep(500);
                System.out.print(y.substring(i, i+1));
            }
            catch(Exception e)
            {
                System.err.println("OOPS");
            }
        }
    }
}
