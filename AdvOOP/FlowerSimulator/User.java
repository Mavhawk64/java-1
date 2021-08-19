package FlowerSimulator;
import java.util.*;
import java.*;
/**
 * Runner for Flower Simulator
 * 
 * @author Maverick Berkland 
 * @version 14 February, 2018
 */
public class User 
{
    public static void main (String [] args)
    {
        //Tester plant = new Tester();
        boolean Losing = true;
        boolean nub = false;
        System.out.println("Welcome to the Plant Simulator");
        System.out.println("-------OPTIONS-------");
        System.out.println("A - Daisy (Easy)");
        System.out.println("B - Dandelion (Medium)");
        System.out.println("C - Piranha Plant (Hard)");
        while(Losing)
        {
            Scanner scan = new Scanner(System.in);
            String abc = scan.nextLine();
            if(abc.equalsIgnoreCase("a"))
            {
                Daisy d1 = new Daisy();
                while(!d1.checkWin())
                {
                    d1.createFlower();
                }

                if(d1.checkWin())
                {
                    Losing = false;
                }

            }
            else if(abc.equalsIgnoreCase("b"))
            {
                Dandelion da1 = new Dandelion();
                while(!da1.checkWin())
                {
                    da1.createFlower();
                }

                if(da1.checkWin())
                {
                    Losing = false;
                }
            }
            else if(abc.equalsIgnoreCase("c"))
            {
                PiranhaPlant mario = new PiranhaPlant();
                while(!mario.checkWin())
                {
                    mario.createFlower();
                }

                if(mario.checkWin())
                {
                    Losing = false;
                }
            }
            else
            {
                Tester test = new Tester();
                while(!test.checkWin())
                {
                    test.createFlower();
                }

                if(test.checkWin())
                {
                    Losing = false;
                }
            }
        }
        System.out.println("You Won!");
    }
}
