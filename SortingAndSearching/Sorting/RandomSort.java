package Sorting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;
/**
 * This is the BOGO Sort
 */
public class RandomSort 
{
    public RandomSort(int [] i) 
    {
        int counter = 0;
        System.out.println("Sorting " + i.length + " elements...");
        while(!isSorted(i)) 
        {
            shuffle(i);
            counter++;
        }
        System.out.println("Solution found! (shuffled " + counter + " times)");
        print(i);
    }

    private void print(int [] i)
    {
        for(int x : i) 
        {
            System.out.print(x + " ");
        }
        System.out.println(" ");
    }

    private void shuffle(int [] i) 
    {
        for(int x = 0; x < i.length; ++x) 
        {
            int index1 = (int) (Math.random() * i.length),
            index2 = (int) (Math.random() * i.length);
            int a = i[index1];
            i[index1] = i[index2];
            i[index2] = a;
        }
    }

    private boolean isSorted(int [] i) 
    {
        for(int x = 0; x < i.length - 1; ++x)
        {
            if(i[x] > i[x+1]) 
            {
                return false;
            }
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers for me to create.");
        int apple = input.nextInt(); 
        int [] i = new int [apple];
        for (int j = 0; j < i.length; j++)
        {
            i[j] = rand.nextInt(apple);
        }
        
        for(int j = 0; j < i.length; j++)
        {
            System.out.print(i[j] + " ");
        }
        System.out.println(" ");
        new RandomSort(i);
    }
}