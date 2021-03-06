package Sorting;
import java.util.Scanner;
import java.util.Random;
public class Insertion
{
    /**
     * @Insertion
     */
    public static void main (String [] args)
    {
        long start = System.nanoTime();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers for you to create.");
        int apple = input.nextInt(); 
        int [] array = new int [apple];
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Please enter number");
            array[i] = input.nextInt();
        }

        //Real Code

        int count = 0;

        for(int i = 1; i < array.length; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if( array[j] < array[j-1] )
                {
                    //temporary variable
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    count++;
                }
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Array in order: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }
        double end = (System.nanoTime() - start)/1000000000 + 0.000000;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Finished in " + end + " seconds, and " + count + " iterations");
    }
}
