package FlowerSimulator;

/**
 * Abstract Class
 * Main Features of Plants Here
 */
public abstract class Plant
{
    int nat;
    int fake;
    int growth; //sum
    int grow; //temp for growth
    double y = 0.0;
    String percent;
    boolean chickenDinner = false;
    int display = 0;
    int fakemin;
    int poison = 0;
    boolean poisoned = false;
    int faketemp = 0;
    int count = 0;
    int nattemp = 0;
    /**
     * Constructor
     */
    Plant()
    {
        nat = 2;
        fake = 2;
        growth = 2; //Start with 2 inches
        grow = growth;
    }

    /**
     * Override this in piranha and tulip classes
     */
    public void menu ()
    {

    }

    /**
     * This is where the multipliers and bonuses get added to 
     * nat and fake
     */
    public abstract void input();

    public void calculateGrowth()
    {
        //LOG NOTES
        if(!poisoned)
            growth = fake + nat;
            else if(growth < 4)
            growth = 2;
            else
            growth--;

        grow = (int)(Math.log(growth));
        y = Math.log(growth);
        percent = Double.toString(y);
        percent = percent.substring(2,4);
        if(grow < 10)
            System.out.println("Your plant is " + percent + "% of the way to a growth spurt");
        poisoned = false;
        faketemp = fake;
        nattemp = nat + fake;
        if(faketemp >= 5)
        {
            fake = 0;
            nat = 2;
        }
        count++;
        calculateFake();
    }

    public void calculateFake()
    {
        fakemin = 5 - faketemp;
        if(faketemp >= 5)
        {
            poison = 0;
            System.out.println("Your plant has been poisoned!");
            growth = 2;
            poisoned = true;
        }
        else
        {
            System.out.println("You are " + fakemin + " away from being poisoned");
        }
    }

    public void printPot()
    {
        for(int i = grow; i >= 2; i--)
        {
            {
                System.out.println("        |" + i + "|");
            }
        }

        if(!chickenDinner) 
        {
            System.out.println("     .- |1| -.         ");
            System.out.println("     \\'-----'/         ");
            System.out.println("      |:.    |          ");
            System.out.println("      |::.   |          ");
            System.out.println("     /::::    \\         ");
            System.out.println("   .:::'       '.       ");
            System.out.println("  /:::           \\      ");
            System.out.println(" ;:::'            ;     ");
            System.out.println(" |:::             |     ");
            System.out.println(" |:::             |     ");
            System.out.println(" |:::             |     ");
            System.out.println(" ;:::             ;     ");
            System.out.println(" \\:::.            /     ");
            System.out.println("  ':::..        .'      ");
            System.out.println("   `^^-------^^`        ");
        }
    }

    public boolean checkWin()
    {
        if(grow > 10)
        {
            System.out.println("It took " + count + " tries to get up to 10 inches.");
            return true;
        }
        else
        {
            return false;
        }
    }
}
