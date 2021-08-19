import java.math.*;
/**
 * Write a description of class UnderscoreHmm here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UnderscoreHmm
{
    public static void main ()
    {
        String x = "The quick brown fox jumps over a lazy dog";
        int y = (int)(Math.random()*x.length());
        String und = "";
        for(int i = 0; i < y; i++)
        {
            und+="_ ";
        }
        System.out.println(und);
    }
}
