package FlowerSimulator;
import java.util.*;
/**
 * Write a description of class Dandelion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dandelion extends Plant implements Flower
{ 
    int sunnyboy = 0;
    int blow = 0;
    @Override
    public void createFlower()
    { 
        menu();
        input();
        drawBlossom();
        printPot();
        calculateGrowth();
    }

    public void drawBlossom()
    {
        System.out.println("     _.--'--._    ");
        System.out.println("   .'. ':. ' :'.  ");
        System.out.println("  '`' : `. `: ':' ");
        System.out.println(" : : '.'. .'.':.`:");
        System.out.println(" :' -`= `+ .= - `:");
        System.out.println(" :.' .'.' :.'.`:':");
        System.out.println("  : : .:`' .:`.': ");
        System.out.println("   '.: . :`. :.'  ");
        System.out.println("     `'--,--'`    ");
    }

    @Override
    public void menu()
    {
        System.out.println("-------OPTIONS-------");
        System.out.println("A - Sunlight & Water");
        System.out.println("B - Blow on seeds");
        System.out.println("C - Grass Seed");
    }

    @Override
    public void input()
    {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if(choice.equalsIgnoreCase("A"))
        {
            nat++;
            sunnyboy++;
        }
        else if(choice.equalsIgnoreCase("B"))
        {
            fake++;
            nat++;
            blow++;
        }
        else if(choice.equalsIgnoreCase("C"))
        {
            fake++;
        }
        else
        {
            System.out.println("Invalid");
            createFlower();
        }

        if(sunnyboy + blow >= 10)
        {
            nat = nat+fake;
            fake = 0;
            fakemin = 5 - fake;
            System.out.println("You are " + fakemin + " away from being poisoned");
            sunnyboy = 0;
            blow = 0;
        }
    }

    Dandelion()
    {
        super();
        createFlower();
    }
}
