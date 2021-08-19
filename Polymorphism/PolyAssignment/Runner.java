package PolyAssignment;
import java.util.*;

/**
-Build me a simple Parent, Child, and Runner
-Upcast the Child method to the Parent
-Attempt to access Child methods through upcasted object
-Call a few of the parents methods through the upcasted object
-Try a few illegal casting maneuvers
-Finally perform a legal downcast
 */
public class Runner
{
    public static void main (String [] args)
    {
        System.out.println("----------Parent Simulator----------");
        Parent p1 = new Parent();
        Child c1 = new Child();
        //Upcasting c2
        //Child c2 = new Parent(); //Bad
        Parent c2 = new Child(); //Upcast
        Parent p2 = (Parent)c1; //Upcast
        //These are disguised as Parents, but are really children.
         Parent p3 = c1; //Upcast
        //Child c3 = (Child)p1; //Failure
        Child c4 = (Child)c2;
        System.out.println("Downcast");
        Scanner scan = new Scanner(System.in);
        String sound = scan.nextLine();
        c2.noise(sound);
        System.out.println("Downcast");
        p2.noise(sound);
        System.out.println("Downcast");
        System.out.println("Hair color");
        String hair = scan.nextLine();
        //c3.hairColor(hair);
        c2.hairColor(hair);
    }
}
