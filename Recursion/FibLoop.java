import java.util.Scanner;
public class FibLoop
{
    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("What n term do you want to go to?");
        int n = scan.nextInt();
        long start = System.nanoTime();
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.println("--For Loop--");
        //System.out.println(a);
        //System.out.println(b);
        for(int i = 0; i < n; i++)
        {
            c = a + b;
            a = b;
            b = c;
            //System.out.println(c);
        }
        long stop = System.nanoTime() - start;
        System.out.println("FibNum Loop: " + c + " Time: " + stop);
    }
}
