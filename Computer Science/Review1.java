import java.util.Scanner;
public class Review1
{
    public static void main ()
    {
        String name = "Maverick";
        
        int x = 9;
        int y = 27;
        int sum = x + y;
        System.out.println("The sum of x and y is: " + sum);
        
        String first = "Maverick";
        String last = "Berkland";
        String full = first + " " + last;
        System.out.println(full);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your first and last name (Hit enter after first name, then enter last name");
        first = scan.nextLine();
        last = scan.nextLine();
        full = first + " " + last;
        
        System.out.println(full);
        
        double z = 9.000;
        char a = 'a';
        boolean hi = true;
        System.out.println("Enter your age.");
        int age = scan.nextInt();
        if(age >= 16)
        {
            System.out.println("You can drive");
        }
        else
        {
            System.out.println("Oh No! You can't drive yet!");
        }
        
        if(age>=19)
        {
            System.out.println("And you can buy a lottery ticket!");
        }
        else if(age>16 && age<19)
        {
            System.out.println("But you can't buy a lottery ticket.");
        }
        else
        {
            System.out.println("You also can't buy a lottery ticket yet!");
        }
        
        if(age>=21)
        {
            System.out.println("You can also drink alcohol legally");
        }
        else if(age>16 && age<21)
        {
            System.out.println("But you can't drink alcohol.");
        }
        else
        {
            System.out.println("You still have multiple years until you can drink");
        }
    }
}
