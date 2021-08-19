package DisasterSimulator;
import java.util.ArrayList;
import java.util.Scanner;
public class PlagueIncMaverick
{
    public void Play ()
    {
        System.out.println("Hello, welcome to Plague Inc.");
        System.out.println("");
        System.out.println("How many people are in your city?");
        Scanner scan = new Scanner(System.in);
        int population = scan.nextInt();
        ArrayList<Integer> populationNum = new ArrayList<Integer>();
        for(int i = 0; i < population; i++)
        {
            populationNum.add(i);
        }
        System.out.println("Now you need to become a virus, press enter to continue.");
        String enter = scan.nextLine();
        Virus(populationNum);
    }

    public void Virus (ArrayList<Integer> populationNum)
    {
        System.out.println("You have successfully became a virus.");
        System.out.println("You now need to evolve to infect people.");
        System.out.println("");
        System.out.println("A. Nausea");
        System.out.println("B. Insomnia");
        System.out.println("C. Coughing");
        Scanner ev = new Scanner(System.in);
        String evolve = ev.nextLine();
        if(evolve.equalsIgnoreCase("a"))
        {
            A(populationNum);
        }
        else if(evolve.equalsIgnoreCase("b"))
        {
            B(populationNum);
        }
        else if(evolve.equalsIgnoreCase("c"))
        {
            C(populationNum);
        }
    }

    public void A(ArrayList<Integer> populationNum)
    {
        System.out.println("You have evolved the symptom Nausea.");
        System.out.println("You have infected all of the people");
        System.out.println("");
        System.out.println("");
        System.out.println("Now you need to destroy the population");
        System.out.println("");
        System.out.println("A. Seizures");
        System.out.println("B. Total Organ Failure");
        System.out.println("C. Necrosis");
        Scanner ev = new Scanner(System.in);
        String evolve = ev.nextLine();
        if(evolve.equalsIgnoreCase("a"))
        {
            AA(populationNum);
        }
        else if(evolve.equalsIgnoreCase("b"))
        {
            AB(populationNum);
        }
        else if(evolve.equalsIgnoreCase("c"))
        {
            AC(populationNum);
        }
    }

    public void B(ArrayList<Integer> populationNum)
    {
        System.out.println("Since you upgraded insomnia, people walk around like zombies, infect the world, you don't need to kill anyone because they are zombies now.");
        System.out.println("With all this activity, you infect 3/4 of the population.");
        int x = populationNum.size()/4-1;
        for(int i = populationNum.size()-1; i > x; i--)
        {
            populationNum.remove(i);
        }
        System.out.println("Population not Infected: " + populationNum.size());
        System.out.println("You need to infect and kill the population.");
        System.out.println("");
        System.out.println("A. Coma");
        System.out.println("B. Tumors");
        System.out.println("C. Cysts");
        Scanner ev = new Scanner(System.in);
        String evolve = ev.nextLine();
        if(evolve.equalsIgnoreCase("a"))
        {
            BA(populationNum);
        }
        else if(evolve.equalsIgnoreCase("b"))
        {
            BB(populationNum);
        }
        else if(evolve.equalsIgnoreCase("c"))
        {
            BC(populationNum);
        }
    }

    public void C(ArrayList<Integer> populationNum)
    {
        System.out.println("With people coughing into eachother's faces, everyone gets infected.");
        System.out.println("You need to evolve to kill everyone.");
        System.out.println("");
        System.out.println("A. Dysentery");
        System.out.println("B. Hemorrhagic Shock");
        System.out.println("C. Necrosis");
        Scanner ev = new Scanner(System.in);
        String evolve = ev.nextLine();
        if(evolve.equalsIgnoreCase("a"))
        {
            CA(populationNum);
        }
        else if(evolve.equalsIgnoreCase("b"))
        {
            CB(populationNum);
        }
        else if(evolve.equalsIgnoreCase("c"))
        {
            CC(populationNum);
        }
    }
    
    public void AA(ArrayList<Integer> populationNum)
    {
        System.out.println("People globally fall on their knees from seizures.");
        System.out.println("About 90% of people have died.");
        int x = populationNum.size()/9-2;
        for(int i = populationNum.size()-1; i > x; i--)
        {
            populationNum.remove(i);
        }
        System.out.println("Population still alive: " + populationNum.size());
        SlowText s1 = new SlowText("After one more day, you finally kill everyone!");
        s1.typer();
    }
    
    public void AB(ArrayList<Integer> populationNum)
    {
        SlowText s2 = new SlowText("The entire Population was wiped out!");
        System.out.println("Good job");
    }
    
    public void AC(ArrayList<Integer> populationNum)
    {
        int x = populationNum.size()/6;
        for(int i = populationNum.size()-1; i > x; i--)
        {
            populationNum.remove(i);
        }
        System.out.println("Population still alive: " + populationNum.size());
        System.out.println("You now need to kill the rest of the people.");
        System.out.println("");
        System.out.println("A. Total Organ Failure");
        System.out.println("B. Bio-Destroyer");
        System.out.println("C. Necroa (Zombies)");
        Scanner ev = new Scanner(System.in);
        String evolve = ev.nextLine();
        if(evolve.equalsIgnoreCase("a"))
        {
            ACA(populationNum);
        }
        else if(evolve.equalsIgnoreCase("b"))
        {
            ACA(populationNum);
        }
        else if(evolve.equalsIgnoreCase("c"))
        {
            ACA(populationNum);
        }
    }
    
    public void BA(ArrayList<Integer> populationNum)
    {
        System.out.println("People globally go into an eternal rest from evolving the Coma symptom.");
        SlowText s4 = new SlowText("The entire Population was wiped out in their sleep!");
    }
    
    public void BB(ArrayList<Integer> populationNum)
    {
        System.out.println("People globally have their heads hurting super bad (from the tumors), so they take cyanide pills to ease the pain.");
        SlowText s2 = new SlowText("The entire Population was wiped out from the global suicides!");
    }
    
    public void BC(ArrayList<Integer> populationNum)
    {
        System.out.println("There are cysts growing everywhere!");
        SlowText s4 = new SlowText("WHAT DO YOU DO!?!");
    }
    
    public void CA(ArrayList<Integer> populationNum)
    {
        
    }
    
    public void CB(ArrayList<Integer> populationNum)
    {
        
    }
    
    public void CC(ArrayList<Integer> populationNum)
    {
        
    }
    
    public void ACA (ArrayList<Integer> populationNum)
    {
        SlowText s3 = new SlowText("After 4 days, the rest of the population was wiped out!");
    }
}
