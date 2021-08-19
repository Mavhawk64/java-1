
/**
 * Write a description of class ModuloFun here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ModuloFun
{
    public static void main (String [] args)
    {
        System.out.println("Have some fun with modulo (%) !");
        System.out.println("Oof " + -1%1);
        for(int x = 0; x < 31; x++)
        {
            System.out.println("X: " + (double)x/10 + " x % 1 = " + x % 10); 
            System.out.println(x % 10 == 0);
        }
    }
}
