
/**
 * Maverick Berkland
 * 1 March, 2017
 */
public class Review2
{
    public static void main ()
    {
        String [] names1 = {"Jim", "Jack", "Jacobo"};
        String [] names = new String[3];
        names[0] = "Jim";
        names[1] = "Jack";
        names[2] = "Jacobo";
        int size = names.length;
        //.length makes value of size = 3
        System.out.println("The Names Array is " + size);
        
        //Two ways to print things:
        //names.length is just an integer
        System.out.println("Without loop: " +names[0] + " " + names[1] + " " + names[2]);
        int doubleIt = names.length + names.length;
        for(int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }
        int [] nums = {5,4,3,2,1};
        //     index   0,1,2,3,4
        for(int i = 0; i < nums.length; i++)
        {
            System.out.println("nums " + nums[i]);
        }
        int [] babs = {100,99,98,97,96};
        //How to go backwards
        for(int i = babs.length-1; i >= 0; i--)
        {
            System.out.println("babs " + babs[i]);
        }
        //Undeclared spots get assigned as the value, zero
        int [] numbers = new int [5];
        numbers[1] = 3;
        numbers[4] = 9;
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers[i]);
        }
        //Out Of Bounds
        //This becomes out of bounds, the 9 is bad, making it go out of bounds
        /**
        * int [] studentsFavNums = {7,27,42,28,64};
        *for(int i = 0; i < 9; i++)
        *{
        *    System.out.println(studentsFavNums[i]);
        *}
        */
        int [] studentsFavNums = {7,27,42,28,64};
        for(int i = 0; i < 5; i++)
        {
            System.out.println(studentsFavNums[i]);
        }
    }
}
