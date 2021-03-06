package Sorting;
import java.util.Scanner;
import java.util.Random;
public class RandomInsertion
{
    /**
     * @Insertion
     */
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers for me to create.");
        int apple = input.nextInt(); 
        int [] array = new int [apple];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(apple);
        }
        
        //Real Code

        long start = System.nanoTime();
        int count = 0;
        System.out.println("Original array: ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }

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
        long end = System.nanoTime() - start;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Finished in " + end + " nano seconds, and " + count + " iterations");
    }
}
