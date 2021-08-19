import java.util.Scanner;
/**
 * I am Maverick Berkland, and I made this program from the resources of this semester.
 * 23 February, 2017
 */
public class GradeTester
{
    public static void main ()
    {
        System.out.println("        ***********************");
        System.out.println("        *******GradeBook*******");
        System.out.println("        ***********************");
        
        Scanner scan = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Please enter the amount of points in your test");
        double points = scan.nextDouble();
        System.out.println("");
        System.out.println("Please enter the amount of students you have:");
        int student = scan.nextInt();
        System.out.println("");
        String [] StudentGrades = new String [student];
        int [] grades = new int[student];
        for(int i = 0; i < student; i++)
        {
           System.out.println("Please enter student " + i + "'s grade on the test out of " + points + " points:");
           grades[i] = scan.nextInt();
        }
        System.out.println("");
        System.out.println("Here are their grades:");
        double sum = 0.0000;
        for(int i = 0; i < student; i++)
        {
            System.out.println(grades[i] + "/" + points);
            sum = grades[i] + sum;
            
        }
        double percent = sum/(points*student);
        System.out.println("Percent: " + percent);
        double min = 0.76;
        for(int i = 0; i <= min;)
        {
          if(percent<= min)
          {
              System.out.println("Would you like to increment?");
              String inc = sc.nextLine();
              if(inc.equalsIgnoreCase ("yes"))
              {
                  System.out.println("By how much?");
                  int incval = scan.nextInt();
                  sum = sum + 1;
                  percent = sum/(points*student);
                  System.out.println("");
                  System.out.println("The new class average is " + percent);
              }
              else if(inc.equalsIgnoreCase ("no"))
              {
                System.out.println("Ok, no increment will be added");
              }
          }
          else
          {
              System.out.println("Your students are doing great, and don't need to be incremented.");
              i+=min;
              i++;
            }
        }
    }
}
