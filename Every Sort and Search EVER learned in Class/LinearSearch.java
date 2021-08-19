
import java.util.Scanner;
import java.util.Random;
public class LinearSearch extends SearchAlgorithm
{
    public void search (int [] nums, int toFind)
    {        
        int target = toFind;
        int x;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == target)
            {
                x = i + 1;
                System.out.println("Found " + nums[i] + "; it was the " + x + " number");
                break;
            }
        }
    }

    @Override
    public String getName()
    {
        return "Linear Search";
    }
}