package Searching;
import java.util.Scanner;
import java.util.Random;
public class LinearSearch
{
    public static void main (String [] args)
    {
        long start = System.nanoTime();
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers (more than 50) for me to create.");
        int apple = input.nextInt(); 
        int [] nums = new int [apple];
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = rand.nextInt(apple);
        }
        
        int target = 5;
        
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                System.out.println("Found " + nums[i] + "; it was the " + i + " number");
                break;
            }
        }
        long stop = System.nanoTime() - start;
        System.out.println("In " + stop + " nanoseconds");
    }
}