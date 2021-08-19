package ChildTest;
import java.util.Scanner;
public class Runner
{
    public static void main (String [] args)
    {
        Derived ch1 = new Derived();
        Derived2 ch2 = new Derived2();
        ch1.doStuff();
        ch2.doStuff();
        ch1.printALine(5);
        for(int i = 8; i < 100; i = i +2)
        {
            if(i%2 == 0)
            {
                if(i<98)
                {
                    System.out.print(i + ", ");
                }
                else
                {
                    System.out.print(i);
                }
            }
        }
        System.out.println("Child 1:");
        ch1.count(9);
        System.out.println("Child 2:");
        ch2.count(8);
        System.out.println("Say something");
        Scanner scan = new Scanner(System.in);
        String y = scan.nextLine();
        ch1.makeExciting(y);
        ch2.makeExciting(y);
    }
}