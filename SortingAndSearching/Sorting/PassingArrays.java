package Sorting;
public class PassingArrays
{
    /**
     * @Array for AP Test!!!
     */
    public static void main (String [] args)
    {
        String [] names = {"Jill","Jan","Jon","Joe"};
        System.out.println("Original Array:");
        for(int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }
        makeExciting(names);
        System.out.println("New Array:");
        for(int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }
        int [] nums = {834,346,754,35,9,765,32};
        addOneThousand(nums);
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println(nums[i]);
        }
    }
    //Know this for AP
    private static void makeExciting ( String [] x )
    {   
        //x[2] = "CAT";
        //Still accesses the memory
        //String [] temp = x;
        //temp[2] = "CATerpillar";
        String [] temp = new String[x.length];
        for(int i = 0; i < x.length; i++)
        {
            temp[i] = x[i];
        }
    }
    
    private static int [] addOneThousand(int [] numbers)
    {
        numbers[4] = numbers[4] + 1000;
        return numbers;
    }
}
