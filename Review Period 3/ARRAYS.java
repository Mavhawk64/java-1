
/**
 * Maverick Berkland
 * Arrays Notes
 * 24 August, 2017
 * Review for Java Basic Skills Exam
 */
public class ARRAYS
{
    public static void main (String [] args)
    {
        System.out.println("***ARRAYS***");
        int [] x = new int [5];
        x[0] = 1;
        x[1] = 1;
        x[2] = 158;
        x[3] = 17;
        x[4] = 5;
        for(int i = 0; i < 5; i++)
        {
            System.out.println(x[i]);
        }
        //Another way to write it
        int [] nums = {1,1,158,17,5};
        
        int [] pows = new int [5];
        for(int i = 0; i < 5; i++)
        {
            pows[i] = (int)Math.pow(2 , i);
            System.out.println(pows[i]);
        }
        System.out.println("MYSTERY");
        int [] mystery = new int [5];
        //Starts with all ZEROS
        /**
        for(int i = 0; i < 5; i++)
        {
            mystery[i] = i+1;
            System.out.println(mystery[i]);
        }
        */
        for(int i = 2; i < 5; i++)
        {
            mystery[i] = i+1;
            System.out.println(mystery[i]);
        }
        
        for(int i = 0; i < 5; i++)
        {
            System.out.println(mystery[i]);
        }
        
        int [] mystery2 = new int [5];
        for(int i = 0; i < 5; i++)
        {
            System.out.println(mystery[i]);
        }
    }
}
