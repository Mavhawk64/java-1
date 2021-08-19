
/**
 * Write a description of class oofP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class oofP
{
    public static void main ()
    {
        char [] x = {'+','-','*','/','^'};
        for(int i = 0; i < x.length; i++)
        {
            System.out.println("<option value=\""+x[i]+"\">"+x[i]+"</option>");
        }
    }
}
