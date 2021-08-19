public class MOD
{
    public static void main (String [] args)
    {
        for (int k = 0; k < 20; k = k + 1)
        {
            if (k % 2 == 0) {
                if(k < 18)
                System.out.print(k + ", ");
                else
                System.out.print(k);
            }
        }
    }
}
