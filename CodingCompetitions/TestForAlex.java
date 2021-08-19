
/**
 * Write a description of class TestForAlex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestForAlex
{
    public static int isCalled = 0;
    public static void main ()
    {
        System.out.println("Welcome to my game show.");
        for(int i = 0; i < 100; i++)formatME();
    }

    public static void formatME()
    {
        isCalled++;
        if(isCalled < 10)
        {
            if(isCalled == 1)
                System.out.println("------------------------------------|");
            System.out.println("------------Question #"+isCalled+"-------------|");
            System.out.println("------------------------------------|");
        }
        else if(isCalled < 100)
        {
            System.out.println("------------Question #"+isCalled+"------------|");
            System.out.println("------------------------------------|");
        }
        else
        {
            System.out.println("-----------Question #"+isCalled+"------------|");
            System.out.println("------------------------------------|");
        }
    }
}
