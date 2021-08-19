package Sorting;
import java.util.Scanner;
import java.util.Random;
/**
 * Maverick's Really Cool Bubble Sort!!!
 */
public class Bubble
{
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int apple = rand.nextInt(25);
        int [] array = new int [apple];

        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Please enter number");
            array[i] = input.nextInt();
        }
                long start = System.nanoTime();
        int count = 0;
        System.out.println("Original array: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }

        for(int i = 0; i < array.length-1; i++)
        {
            if( array[i] > array[i+1] )
            {
                //temporary variable
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                i = -1;
                count++;
            }
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Array in order: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }
        double end = ((System.nanoTime() - start)/1000000000) + 0.0000000;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Finished in " + end + " seconds, and " + count + " iterations");
    }
}
