
/**
 * These are the MultiLoop notes shared from Maverick to Jacob
 */
public class MultiLoop
{
    public static void main ()
    {
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                System.out.println("Out: " + i + "  In: " + j);
            }
        }
        for(int x = 1; x <= 100; x++)
        {
            System.out.println("");
        }
        for(int i = 1; i <= 5; i++)
        {
            for(int j = 1; j <= 5; j++)
            {
                for(int h = 1; h <= 5; h++)
                {
                    for(int k = 1; k <= 5; k++)
                    {
                        for(int l = 1; l <= 5; l++)
                        {
                            System.out.println("Loop 1: " + i + "   Loop 2: " + j + "   Loop 3: " + h + "   Loop 4: " + k + "   Loop 5: " + l);
                        }
                    }   
                }
            }
        }
        String [] PennyPatVol = {"Tim", "Jan", "Joe", "John"};
        String [] RedCrossVol = {"Jim","Jan","Jeff","Joe"};
        for(int i = 0; i < PennyPatVol.length; i++)
        {
            for(int j = 0; j < RedCrossVol.length; j++)
            {
                if(PennyPatVol[i].equals(RedCrossVol[j]))
                {
                    System.out.println("Outstanding Citizen!!");
                    System.out.println(RedCrossVol[j]);
                }
            }
        }
    }
}
