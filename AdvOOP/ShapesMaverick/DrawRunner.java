package ShapesMaverick;
import java.util.Scanner;
/**
 * Write a description of class DrawRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawRunner
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 2; i++)
        {
            System.out.println("What shape would you like to draw? (Square, Rectangle, Triangle, Diamond, or no)");
            Scanner scan = new Scanner(System.in);
            String shape = scan.nextLine();
            boolean oops = false;
            boolean NO = false;
            if(shape.equalsIgnoreCase("Square"))
            {
                Square s1 = new Square();
            }
            else if(shape.equalsIgnoreCase("Rectangle"))
            {
                Rectangle r1 = new Rectangle();
            }
            else if(shape.equalsIgnoreCase("Triangle"))
            {
                Triangle t1 = new Triangle();
            }
            else if(shape.equalsIgnoreCase("Diamond"))
            {
                Diamond d1 = new Diamond();
            }
            else if(shape.equalsIgnoreCase("no"))
            {
                System.out.println("Seriously?");
                NO = true;
                i = 100;
            }
            else
            {
                System.out.println("Try again...");
                oops = true;
                i--;
            }

            if(!oops && NO)
            {
                System.out.println("Are you sure?");
                String again = sc.nextLine();
                if(again.contains("y") || again.contains("Y"))
                {
                    i = 100;
                }
                else
                {
                    i = 0;
                }
            }
            else if(!oops)
            {
                System.out.println("Play again?");
                String again = sc.nextLine();
                if(again.contains("y") || again.contains("Y"))
                {
                    i = 0;
                }
                else
                {
                    i = 100;
                }
            }
        }
    }
}
