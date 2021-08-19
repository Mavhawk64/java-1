
/**
 * Write a description of class UFFF here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UFFF
{
    public static void main (String [] args)
    {
        int x = 3;
        int y = 4;
        int temp = x;
        for(int i = 0; i < y-1; i++)
        {
            for(int j = 0; j < temp; j++)
            {
                x++;
                System.out.println(x);
            }
        }

        // print 100 % 0; 
        System.out.println(getRemainder(100, 7)); 
    }

    // This function returns remainder of 
    // num/divisor without using % (modulo) 
    // operator 
    static int getRemainder(int num, int divisor) 
    { 
        return (num - divisor * (num / divisor)); 
    } 

    // Driver program to test above functions 

}
