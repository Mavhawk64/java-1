import java.util.Scanner;
/**
 * The while loop, our most basic loop.
 */
public class WhileLoop
{
    public static void main ()
    {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        //Always count 0 as an iteration
        while(count <= 7)
        {
            System.out.println(count + ": Hello");
            count = count+1;
        }
        String pass = "";
        int tryCount = 0;
        while(!(pass.equalsIgnoreCase ("DANK")))
        {
            System.out.println("Please enter the password!!!");
            pass = sc.nextLine();
            if(pass != ("DANK"))
            {
                System.out.println("DENYED");
                tryCount = tryCount + 1;
                if(tryCount ==10)
                {
                    System.out.println("You have reached 10 attempts");
                    System.out.println("You have been locked out of your account");
                    pass = "DANK";
                }
            }
        }
    }
}