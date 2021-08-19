package src;

/**
 * Lab to practice Checkstyle formatting.
 * 
 */
public class CheckstyleLab
{
    private static final int arr_size = 10;

    /**
     * Main method which calculates the sum of the squares of the integers 1 to 10 inclusive.
     * @param args Command line arguments (Unused)
     */
    public static void main(String[] args)
    {

        int[] Squares = new int[arr_size];

        for(int i = 0; i < 10; i++) {
            Squares [i] = (int)Math.pow(i, 2);
            System.out.printf("Square of %d  is %d\n", i+1, Squares[i]);
        }

        System.out.printf("The Sum of the Squares is %d!\n\n",sumArray(Squares));

    }

    //This method returns the sum of the values in the arr parameter or zero when arr is null.
    public static int sumArray(int[] arr)
    {
        int sum = 0;
        for (int i = 1; i <= arr.length; i++)
            sum+=arr[i];

        return sum;
    }

}
