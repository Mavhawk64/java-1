package TheUltimateClass;
import java.util.Scanner;
/**
 * Write a class that uses the principles of Encapsulation and meets all of the following criteria:
 * 1. Has at least three instance variables with access modifiers.
 * 2. Sets all instance variables to generic values in a default constructor.
 * 3. Uses an overloaded constructor to set the instance variables to specific values.
 * 4. Uses the word this to refer to variables of the class
 * 5. Makes use of an overloaded method.
 * 6. Has at least one static variable and static method.
 * 7. Uses at least one getter and setter to control access to a private variable.
 * 8. Uses at least 5 “blue comments” which will add developer notes to the documentation.
 * 9. Uses at least 3 single line comments to make quick notes about various functionality
 * 10. Create a “runner” class to test overloaded methods, constructors, static variables, and
 * getters/setters.
 */
public class TheUltimateClassRunner
{
    /**
     * Maverick Berkland's main method for the Ultimate Class Project
     */
    public static void main (String [] name)
    {
        //Testing boolean beautiful
        Fish f1 = new Fish();
        System.out.println("Is Fish #1 beautiful?");
        if(f1.beautiful)
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println("Is your fishtank fresh-water, or salt-water? (type fresh/salt)");
        Scanner scan = new Scanner(System.in);
        String water = scan.nextLine();
        boolean saltWater;
        water = water.toLowerCase();
        if(water.contains("fresh"))
            saltWater = false;
        else
            saltWater = true;
        Fish f2 = new Fish(saltWater);
        f2.makeBubble();
        System.out.println("What is the type of fish you have?");
        String type = scan.nextLine();
        System.out.println("What color is your " + type + "?");
        String color = scan.nextLine();
        Fish f3 = new Fish(saltWater, color, type);
        System.out.println("Your fish tank is a " + water + " water tank, with three fish.");
        System.out.println("Your second fish is ok with being in " + water + " water");
        System.out.println("Your third fish is a " + f3.getColor() + " " + f3.getType() + " that lives in " + water + " water");
        System.out.println("Uh oh... fish 2 died...");
        if(saltWater)
        f2.minusSaltPop();
        else
        f2.minusFreshPop();
    }
}
