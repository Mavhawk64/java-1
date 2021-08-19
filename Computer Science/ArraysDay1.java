import java.util.Scanner;
/**
 * An Array is a list where every item in the list has an index
 */
public class ArraysDay1
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        String [] MavsFavs = new String [7];
        MavsFavs[0] = "Learning";
        MavsFavs[1] = "Sleeping";
        MavsFavs[2] = "Eating";
        MavsFavs[3] = "Playing Video Games With Chase";
        MavsFavs[4] = "SUMMER";
        MavsFavs[5] = "Any break during the school year";
        MavsFavs[6] = "Driving a car";
        for(int i = 0; i < 7; i++)
        {
            System.out.println(MavsFavs[i]);
        }
        System.out.println("How many Employees are in your company?");
        int employee = scan.nextInt();
        int [] salaries = new int[employee];
        for(int j = 1; j <= employee; j++)
        {
            System.out.println("Please enter the salary of an employee: " + j);
            salaries[j] = scan.nextInt();
        }
        System.out.println("Salary Report");
        for(int i = 0; i < employee; i++)
        {
            System.out.println(salaries[i]);
        }
        System.out.println("Now, would you like to give them a raise?");
        Scanner scan2 = new Scanner(System.in);
        for(int i = 0; i < 1; i++)
        {
            String choice = scan2.nextLine();
            if(choice.equalsIgnoreCase("yes"))
            {
                System.out.println("By how much?");
                int increase = scan.nextInt();
                System.out.println("OK... adding by " + increase + ".");
                for(int f = 0; f < employee; f++)
                {
                    salaries[f] = salaries[f] + increase;
                    System.out.println("Here are your new salaries:");
                    System.out.println(salaries[i]);
                }
            }
            else if(choice.equalsIgnoreCase("no"))
            {
                System.out.println("Okay. Weirdo.");
            }
            else
            {
                System.out.println("Oops, did you type yes or no wrong?");
                System.out.println("Now you may enter your answer.");
                i--;
            }
        }
    }
}
