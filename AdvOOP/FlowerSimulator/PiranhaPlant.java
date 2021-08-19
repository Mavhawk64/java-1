package FlowerSimulator;
import java.util.*;
/**
 * Write a description of class PiranhaPlant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PiranhaPlant extends Plant implements Flower
{
    @Override
    public void createFlower()
    {
        menu();
        input();
        drawBlossom();
        printPot();
        calculateGrowth();
    }

    @Override
    public void menu()
    {
        System.out.println("-------OPTIONS-------");
        System.out.println("A - Luigi");
        System.out.println("B - Metal Mario");
        System.out.println("C - Kart");
    }

    @Override
    public void input()
    {
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if(choice.equalsIgnoreCase("A"))
        {
            nat++;
            fake++;
        }
        else if(choice.equalsIgnoreCase("B"))
        {
            nat = 0;
            fake++;
        }
        else if(choice.equalsIgnoreCase("C"))
        {
            fake+=2;
            nat++;
        }
        else if(choice.equalsIgnoreCase("up up down down left right left right B A start"))
        {
            nat = 20 + fake + nat;
            fake = 0;
            System.out.println("You have found the secret glitch!!!");
        }
        else
        {
            System.out.println("Invalid");
            createFlower();
        }

        Random rand = new Random();
        int randy = rand.nextInt(5);
        int rando = rand.nextInt(5);
        if(randy == rando)
        {
            nat = nat+fake;
            fake = 0;
            fakemin = 5 - fake;
            System.out.println("You are " + fakemin + " away from being poisoned");
        }
    }

    public void drawBlossom()
    {

        System.out.println("     __________");
        System.out.println("    /          \\");
        System.out.println("   /   ---v---v-)");
        System.out.println("   \\   \\       ");
        System.out.println("    \\   -^--^--^)");
        System.out.println("     \\_________/");

    }

    PiranhaPlant()
    {
        super();
        createFlower();
    }
}
