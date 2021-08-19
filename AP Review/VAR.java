
/**
 * Write a description of class VAR here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VAR
{
    public static void main (String [] args)
    {
        int var1 = 0;
        int var2 = 2;

        while ((var2 != 0) && ((var1 / var2) >= 0))
        {
            var1 = var1 + 1;
            var2 = var2 - 1;
        }
        System.out.println(var1 + " " + var2);
    }
}
