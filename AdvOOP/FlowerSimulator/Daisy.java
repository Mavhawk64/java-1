package FlowerSimulator;
import java.util.*;
/**
 * Write a description of class Daisy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Daisy extends Plant implements Flower
{
    int sun = 0;
    int water = 0;

    @Override
    public void drawBlossom()
    { 
        System.out.println("        .-.           ");
        System.out.println("  __   /  \\   __     ");
        System.out.println(" (  `'.\\  /.'`  )    ");
        System.out.println("  '-._.(;;;)._.-'     ");
        System.out.println("  .-'  ,` `,  '-.     ");
        System.out.println(" (__.-'/  \\'-.__)    ");
        System.out.println("       \\  /          ");
        System.out.println("        '-'           ");
    }

    @Override
    public void menu()
    {
        System.out.println("-------OPTIONS-------");
        System.out.println("A - Sunlight");
        System.out.println("B - Water");
        System.out.println("C - Miracle-Gro");
    }

    @Override
    public void input()
    {

        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if(choice.equalsIgnoreCase("A"))
        {
            if(water == 2)
            {
                nat+=2;
                //water = 0;
                System.out.println("WATER");
            }
            else
                nat++;
            //System.out.println(nat);

            sun++;
            if(water + sun >= 10)
            {
                nat = nat+fake;
                fake = 0;
                fakemin = 5 - fake;
                System.out.println("You are " + fakemin + " away from being poisoned");
                sun = 0;
                water = 0;
            }
        }
        else if(choice.equalsIgnoreCase("B"))
        {
            if(sun == 2)
            {
                nat+=2;
                //sun = 0;
                 System.out.println("SUNLIGHT");
            }
            else
                nat++;
            //System.out.println(nat);

            water++;
            if(water + sun >= 10)
            {
                nat = nat+fake;
                fake = 0;
                fakemin = 5 - fake;
                System.out.println("You are " + fakemin + " away from being poisoned");
                sun = 0;
                water = 0;
            }
        }
        else if(choice.equalsIgnoreCase("C"))
        {
            fake++;
            //  nat+=2;
            //System.out.println("fake " + fake);
            //System.out.println("nat " + nat);

            System.out.println("FAKE SOIL");
        }
        else if(choice.equalsIgnoreCase("S"))
        {
            nat+=10;
        }
        else
        {
            System.out.println("Invalid");
            createFlower();
        }

    }

    Daisy()
    {
        super();
        createFlower();
    }

    @Override
    public void createFlower()
    {
        menu();
        input();
        drawBlossom();
        printPot();
        calculateGrowth();
    }
}
