import java.util.Scanner;
public class Input
{
public static void main (String [ ] args)
{
 //This is the machine that scans called sc
 Scanner sc = new Scanner(System.in);
 //Must tell user what to type
 System.out.println("Please enter a number!");
 //Must tell machine sc to get next int and save it
 int x = sc.nextInt();
 x = x - 10;
 System.out.println(x);
 System.out.println("Please enter a decimal");
 double decVal = 3.141592653589793238462;
 System.out.println(decVal);
 double y = 3;
 double z = 4;
 double division = y/z;
 System.out.println(division);
 System.out.println("Please enter your name");
 //Set up a new scanner
 Scanner sd = new Scanner(System.in);
 String name = sd.nextLine();
 System.out.println("Hello, " + name);
 System.out.println("How are you, " + name + "???");
 String response = sd.nextLine();
 
}
}
