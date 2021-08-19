
/**
 * Maverick Berkland
 * Learning about ! && ||
 * 28 August, 2017
 */
public class LogicNotes
{
    public static void main (String [] args)
    {
        /**
         * Logical AND &&
         * 
         * F + F = F
         * F + T = F
         * T + F = F
         * T + T = T
         */
        int x = 3;
        boolean y = true;
        if(x > 2 && y)
        {
            System.out.println("YES, AND WILL EVALUATE TO TRUE");
        }
        
        /**
         * Logical OR ||
         * 
         * F + F = F
         * F + T = T
         * T + F = T
         * T + T = T
         */
        int a = 6;
        boolean b = false;
        if(a < 3 || !b)
        {
            System.out.println("YES, OR WILL EVALUATE TO TRUE");
        }
    }
}
