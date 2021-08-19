package PolyDog;
import java.util.*;
/**
 * Polymorphism
 * Refers to Java's ability to make multiple changes to code during runtime.
 */
public class DogPark
{
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal: ");
        double dec = sc.nextDouble();
        int x = (int)dec;
        System.out.println(" HA HA HA, your decimal is now an integer!!! " + x);
        //It isn't like casting primitives
        Husky h1 = new Husky();
        boolean y = h1.dealsWithWinter();

        /*Class cast exception #1:
         * Dog d = new Dog();
         * Husky h = (Husky)d;
         */

        Husky h3 = new Husky();
        Dog d3 = h3; //Legal upcast... Husky is now protected
        Dog dog1 = new Husky(); //Upcast

        /**
         * Legal Downcast
         */
        Husky husky1 = (Husky)dog1;

        /**
         * Remember Downcasting can lead to problems.
         * Use instanceof to check before downcasting.
         */

        if(getDog() instanceof Husky)
        {
            Husky hu = (Husky)getDog();
        }
        else if(getDog() instanceof Poodle)
        {
            Poodle po = (Poodle)getDog();
        }
        else
        {
            System.out.println("It's just a dog!");
        }
        /*
         * Class cast exception #1:
         * //Poodle p = (Poodle)d3;
         */
        /*
         * Class cast exception #2:
         * Poodle p = (Poodle)dog1;
         */

        /*
         * Class cast exception #3:
         * Cannot cast laterally
         * Cannt make something into something it never was.
         * NOT LIKE CASTING PRIMITIVES
         * Husky husky2 = new Husky();
         * Poodle p2 = (Poodle)husky2;
         */

        //Polymorphism

        Dog d1 = h1;

        //d1.dealsWithWinter();
        Husky h2 = (Husky)d1;
        h2.dealsWithWinter();

    }

    public static Dog getDog()
    {
        Husky a = new Husky();
        Dog d1 = a; //Legal upcast
        return d1;
    }
}
