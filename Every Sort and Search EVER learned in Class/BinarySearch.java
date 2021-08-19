import java.util.Scanner;
import java.util.Random;
public class BinarySearch extends SearchAlgorithm
{
    public void search (int [] nums, int toFind)
    {
        System.out.println("Welcome to the Binary Search.");
        int low = nums[0];
        int high = nums[(nums.length)-1];
        int target = toFind;
        int middleIndex = 0;
        int i = 0;
        int x;
        while(target != nums[middleIndex])
        {
            middleIndex = middleIndex/2;
            if(nums[middleIndex] > target)
            {
                high = middleIndex - 1;
            }
            else
            {
                low = middleIndex +1;
            }
            
            if(nums[i] == target)
            {
                x = i + 1;
                System.out.println("Found " + nums[i] + "; it was the " + x + " number");
                break;
            }
            i++;
        }
    }
    
    @Override
    public String getName()
    {
        return "Binary Search";
    }
}