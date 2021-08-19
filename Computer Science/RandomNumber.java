import java.util.Random;
public class RandomNumber
{
    public static void main ()
    {
        Random rand = new Random();
        int x = rand.nextInt(100001);
        while(x<100000)
        {
            x = rand.nextInt(100001); //numbers 0-100000
            System.out.println(x);
            if(x==100000)
            {
                System.out.println("You have reached number 100000");
            }
        }
    }
}

