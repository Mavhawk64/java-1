
public class SPECIALNUMS
{
    public static int scoresSpecial(int[] a, int[] b) {
        int [] x = new int[a.length];
        int [] y = new int[b.length];
        int j = 0, k = 0; //x, y
        int big, tall; //x, y
        for(int i = 0; i < a.length; i++)
        {
            if(a[i]%10 == 0)
            {
                x[j] = a[i];
                j++;
            }
            if(b[i]%10 == 0)
            {
                y[k] = a[i];
                k++;
            }
        }
        big = x[0];
        tall = y[0];
        for(int i = 0; i < j; i++)
        {
            if(x[i] > big)
                big = x[i];
            if(y[i] > tall)
                tall = y[i];
        }
        return big + tall;
    }
    
    public static void main(String [] args)
    {
        int [] a = new int [10];
        int [] b = new int [10];
        for(int i = 0; i < 10; i++)
        {
            a[i] = i+7;
            b[i] = i + 9;
            System.out.print(a[i] + " ");
        }
        System.out.println("");
        for(int i = 0; i < 10; i++)
        {
            System.out.print(b[i] + " ");
        }
        System.out.println("Scores: " + scoresSpecial(a, b));
    }
}
