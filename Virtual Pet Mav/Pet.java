package VirtualPet;
import java.util.Scanner;
/**
 * This class is the meat/potatoes 
 * of the animal/game.
 */
public class Pet
{
    //Attributes
    public String trainerName;
    public String petName;
    //Basic Needs
    private int Hunger;
    private int Sleep;
    private int Bathroom;
    private int Sit;
    private int Speak;
    private int Fetch;
    private int Walk;
    private int Tug;
    //Anything that is trainable needs
    // a new Trainer Object associated with it
    private Trainer toEat = new Trainer();
    private Trainer toSleep = new Trainer();
    private Trainer toBathroom = new Trainer();
    private Trainer toSit = new Trainer();
    private Trainer toSpeak = new Trainer();
    private Trainer toFetch = new Trainer();
    private Trainer toWalk = new Trainer();
    private Trainer toTug = new Trainer();
    //Timers for life
    private Timer lifeStopwatch = new Timer();
    private Timer bathroomStopwatch = new Timer();
    private Timer toEatStopwatch = new Timer();
    private Timer toSleepStopwatch = new Timer();
    /**
     * Constructor for objects of class Pet
     */
    public Pet()
    {
        setNames();
        Sleep = 5;
        Hunger = 20;
        Bathroom = 0;
        lifeStopwatch.start();
        bathroomStopwatch.start();
    }

    private void setNames()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        trainerName = scan.nextLine();
        System.out.println("Please enter your pets name: ");
        petName = scan.nextLine();
    }

    public void giveCommands()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello trainer " + trainerName);
        System.out.println("What do you want " + petName + " to do?");
        String choice = scan.nextLine();
        choice = choice.toLowerCase();
        if(choice.contains("bathroom") ||  choice.contains("restroom") || choice.contains("wc"))
        {
            goToBathroom();
        }//Add commands in else if's 
        else if(choice.contains("eat") || choice.contains("food") || choice.contains("hunger"))
        {
            goToEat();
        }
        else if(choice.contains("sleep"))
        {
            toSleep();
        }
        else if(choice.contains("sit"))
        {
            toSit();
        }
        else if(choice.contains("speak"))
        {
            toSpeak();
        }
        else if(choice.contains("fetch"))
        {
            toFetch();
        }
        else if(choice.contains("come") || choice.contains("walk"))
        {
            toWalk();
        }
        else if(choice.contains("tug"))
        {
            toTug();
        }
        else
        {
            System.out.println("Can't do that, " + petName + " can only...");
            System.out.println("'bathroom', 'eat', 'sleep', 'sit', 'speak', 'fetch', 'walk', and 'tug'");
        }
    }

    private void goToBathroom()
    {
        if(toBathroom.randomChance() >= 6)//is it trained
        {
            if(Bathroom > 30)//Does it have to go
            {
                Bathroom = 0;
                Sleep += 5;
                bathroomStopwatch.start();
                System.out.println(petName + " goes to the neighbors lawn just like you trained it to!");
                printStats();
            }
            else
            {
                bathroomStopwatch.start();
                System.out.println(petName + " does not have to go!");
                printStats();
            }
        }
        else
        {
            System.out.println("In an act of disobedience " + petName + " does not go to the bathroom!");
            System.out.println(petName + " Has a " + toBathroom.printStatus() + " chance of going to the bathroom.");
            Sleep += 5;
        }
    }

    private void printStats()
    {
        System.out.println(petName + " STATS:");
        System.out.println("Hunger: " + Hunger + "/100");
        System.out.println("Sleep: " + Sleep + "/100");
        System.out.println("Bathroom: " + Bathroom + "/100");
        System.out.println("Sit " + Sit + "/100");
    }

    public boolean checkLife()
    {
        //You will need to update and put hunger and sleep
        if(Bathroom > 100)
        {
            System.out.println("OH NO, " + petName + " has exploded!");
            System.out.println("You should have let " + petName + "outside to use the restroom");
            lifeStopwatch.stop();
            System.out.println(petName + " live for..." +  lifeStopwatch.elapsedTime() + "seconds.");
            return false;
        }
        else if(bathroomStopwatch.elapsedTime() > 60)
        {
            System.out.println("You should have let " + petName + "outside to use the restroom");
            lifeStopwatch.stop();
            System.out.println(petName + " live for..." +  lifeStopwatch.elapsedTime() + "seconds.");        
            return false;
        }
        else if(Hunger > 60)
        {
            System.out.println("OH NO!!! " + petName + " starved to death!");
            return false;
        }
        else if(Sleep > 90)
        {
            System.out.println("OH NO!!! " + petName + " died from sleep deprivation!");
            return false;
        }
        else if(bathroomStopwatch.elapsedTime() > 30)
        {
            System.out.println("Oh no, " + petName + " looks like he's going to explode!!");
            return true;
        }
        return true;
    }

    public void goToEat ()
    {
        if(toEat.randomChance() >= 6)
        {
            if(Hunger > 15)
            {
                Hunger = 0;
                Sleep -=2;
                Bathroom += 5;
                toEatStopwatch.start1();
            }
            else
            {
                toEatStopwatch.start1();
                System.out.println(petName + " is too full to eat!");
                printStats();
            }
        }
        else
        {
            System.out.println(petName + " is being bad, therefore it won't eat");
            System.out.println(petName + toEat.printStatus() + " chance to eat.");
            Sleep -=2;
            Bathroom += 5;
        }
    }

    public void toSleep()
    {
        if(toSleep.randomChance() >= 6)
        {
            if(Sleep > 60)
            {
                Sleep = 0;
                Hunger += 15;
                Bathroom += 15;
                toSleepStopwatch.start2();
            }
            else
            {
                toSleepStopwatch.start2();
                System.out.println(petName + " is not tired.");
                printStats();
            }
        }
        else
        {
            System.out.println("In an act of disobedience, " + petName + " chooses not to go to bed!");
            System.out.println(petName + toSleep.printStatus() + " chance to sleep.");
            Hunger += 15;
            Bathroom += 15;
        }
    }
    
    public void toSit()
    {
        if(toSit.randomChance() >= 6)
        {
            System.out.println(petName + " is sitting.");
        }
        else
        {
            System.out.println(petName + " is being stupid, so it isn't sitting");
        }
    }
    
    private void toSpeak()
    {
        if(toSpeak.randomChance() >= 6)
        {
            System.out.println("RUFF");
            System.out.println("WOOF");
        }
        else
        {
            System.out.println(petName + " is being tooooooo bad, it is sitting in silence.");
        }
    }
    
    private void toFetch()
    {
        if(toFetch.randomChance() >= 6)
        {
            System.out.println("Run, " + petName + ", go fetch the ball!!!");
            Hunger += 5;
            Sleep += 5;
            Bathroom += 5;
        }
        else
        {
            System.out.println(petName + " has the ball, but isn't giving it back.");
            Hunger += 5;
            Sleep += 5;
            Bathroom += 5;
        }
    }
    
    private void toWalk()
    {
        if(toWalk.randomChance() >= 6)
        {
            System.out.println(trainerName + ": Come on " + petName + ", let's go for a walk.");
            Hunger += 5;
            Sleep += 5;
            Bathroom = 0;
        }
        else
        {
            System.out.println("OH NO!!!" + petName + " chewed through the leash, you need to buy a new one...");
            System.out.println(trainerName + " ***Buys New Leash***");
            Bathroom += 5;
        }
    }
    
    private void toTug()
    {
        if(toTug.randomChance() >= 3)
        {
            System.out.println(petName + " grabs the rope and plays Tug O' War");
            Hunger += 5;
            Sleep += 5;
            Bathroom += 5;
        }
        else
        {
            System.out.println(petName + " steals a pillow and runs off and jumps into the pool");
            System.out.println(trainerName + ": NOOO! DON'T PEE IN THE POOL!!!!");
            System.out.println(petName + " ***Pees in pool***");
            Bathroom = 0;
        }
    }
    
    public boolean checkTrained()
    {
        if(toBathroom.randomChance()>6 && toSit.randomChance()>6)
        {
            System.out.println("Yes... " + petName + " Is Fully Trained!");
            return true;
        }
        else
        {
            return false;
        }
    }
}
