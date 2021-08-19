
/**
 * Maverick Berkland
 * Proof By EXHAUSTION
 * Random Number Range Formula
 * 22 August, 2017 (THE DAY AFTER THE TOTAL ECLIPSE!!!)
 */
public class RangeChecker
{
    public static void main (String [] args)
    {
        System.out.println("******RANGE CHECKER******");
        for(int i = 0; i < 5000; i++)
        {
            double ran = Math.random(); //Generates between 0 - 1 only
            int result = (int)((ran * 23) + 3); //I WAS SOOOOOO CLOSE, I HAD EVERYTHING... BUT I HAD 22 INSTEAD OF 23!!!
            //3 - 25
            if(result > 25)
            {
                System.out.println("ERROR, GREATER THAN 25");
            }
            else if(result < 3)
            {
                System.out.println("ERROR, LESS THAN 3");
            }
            else if(result == 25 || result == 3)
            {
                System.out.println("THIS IS " + result + ": " + i);
            }
            else
            {
                System.out.println(result + ": " + i);
            }
        }
    }
}
