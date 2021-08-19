public class Max
{
    public static void main ()
    {
        System.out.println("Initializing...");
        System.out.println(sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(sequence(new int[]{1,2,3,4,5,6,7,8,9,-100}));
    }

    public static int sequence(int[] arr)
    {
        boolean hasNeg = false;
        boolean hasPos = false;
        
        int tot = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] < 0)
                hasNeg = true;
            if(arr[i] > 0)
                hasPos = true;
            tot+= arr[i];
        }
        
        if(!hasNeg)
            return tot;
        
        if(!hasPos)
            return 0;
        
        //Hard stuff...
        
        int max = tot > 0 ? tot : 0;
        
        for(int i = 0; i < arr.length; i++) //checks one at a time to see if it alone is larger than the total sum
        {
            if(arr[i] > max)
                max = arr[i];
        }
        
        for(int i = 2; i < arr.length; i++) //2 per subarray, 3, then 4, then 5, then ...
        {
            for(int j = 0; j < arr.length-i+1; j++) 
            {
                System.out.println("I: " + i + " J: " + j);
                int sum = 0;
                for(int k = j; k < i+j; k++)
                {
                    sum += arr[k];
                    System.out.print(arr[k] + " ");
                }
                System.out.println("\nSUM: " + sum);
                if(sum > max)
                    max = sum;
                System.out.println("MAX: " + max);
            }
        }
        System.out.println("\n\n");
        return max;
    }
}