package Sorting;
import java.util.Scanner;
import java.util.Random;
public class Selection
{
    public static void main ( String [] args )
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Please enter a number for a max amount of numbers for me to create.");
        int n = input.nextInt(); 
        int [] array = new int [n];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = rand.nextInt(n);
        }
        int min = n;
       for(int i = 1; i < n-1; i++)
        {
            min = i;
            for(int j = i + 1; j < n; j++)
            {
                if(array[j] < array[min])
                {
                    min = j;
                }
            }
            if(min != i)
            {
                //swap
                array[min] = array[i];
                array[i] = array[i+1];
                array[i+1] = min;
                i = -1;
            }
        }
        
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + "  ");
        }
        
    }
}
