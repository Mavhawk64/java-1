package PlagueIncSimulator;
import java.util.*;
/**
 * Write a description of class City here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class City
{
    ArrayList  <Integer> population = new ArrayList<Integer>();
    LinkedList <Integer> sick = new LinkedList<Integer>();
    LinkedList <Integer> dead = new LinkedList<Integer>();
    LinkedList <Integer> healthy = new LinkedList<Integer>();
    long totpop = 0;
    int count = 1; //First initiation is the first day
    public void createCity()
    {
        System.out.println("-----City-----");
        System.out.println("A. Illinois");
        System.out.println("B. New York");
        System.out.println("C. Massachusetts");
        System.out.println("D. Florida");
        System.out.println("E. Nebraska");
        System.out.println("F. California");
        System.out.println("DO NOT CHOOSE THE BIGGEST POPULATIONS... THEY DO NOT WORK BECAUSE THE AMOUNT OF PEOPLE IS TOO BIG FOR THE ARRAY!!! (Nebraska works best)");
        Scanner s = new Scanner(System.in);
        String city = s.nextLine();
        city = city.toLowerCase();
        if(city.contains("a"))
        {
            Illinois();
        }
        else if(city.contains("b"))
        {
            NewYork();
        }
        else if(city.contains("c"))
        {
            MA();
        }
        else if(city.contains("d"))
        {
            Florida();
        }
        else if(city.contains("e"))
        {
            Nebraska();
        }
        else
        {
            California();
        }
    }

    public void getPop(int infect, int lethal)
    {
        if(!checkSick())
        {
            if(infect >= 30)
            {
                //Infect all
                for(int i = population.size(); i > 0; i--)
                {
                    sick.add(i);
                }

                for(int i = healthy.size(); i > 0; i--)
                {
                    healthy.remove(i);
                }
            }
            else if(infect < 12)
            {
                System.out.println("Infectivity: " + infect);
                for(int i = infect*2; i > 0; i--)
                {
                    if(sick.size() <= population.size())
                    {
                        sick.add(i);
                        healthy.remove(i);
                    }
                    else
                        break;
                }
            }
            else  if(infect < 20)
            {
                System.out.println("Infectivity: " + infect);
                for(int i = sick.size()*3; i > 0; i--)
                {
                    if(sick.size() <= population.size())
                    {
                        sick.add(i);
                        healthy.remove(i);
                    }
                    else
                        break;
                }
            }
            else
            {
                System.out.println("Infectivity: " + infect);
                for(int i = sick.size()*4; i > 0; i--)
                {
                    if(sick.size() <= population.size())
                    {
                        sick.add(i);
                        healthy.remove(i);
                    }
                    else
                        break;
                }
            }

            if(lethal >= 35)
            {
                for(int i = sick.size(); i > 0; i--)
                {
                    dead.add(i);
                }

                for(int j = sick.size(); j > 0; j--)
                {
                    sick.remove(j);
                }
            }
            else if(lethal < 12)
            {
                System.out.println("Lethality: " + lethal);
                for(int i = lethal*2; i > 0; i--)
                {
                    if(dead.size() <= sick.size())
                    {
                        dead.add(i);
                        sick.remove(i);
                    }
                    else
                        break;
                }
            }
            else if(lethal < 20)
            {
                System.out.println("Lethality: " + lethal);
                for(int i = dead.size()*3; i > 0; i--)
                {
                    if(dead.size() <= sick.size())
                    {
                        dead.add(i);
                        sick.remove(i);
                    }
                    else
                        break;
                }
            }
            else
            {
                System.out.println("Lethality: " + lethal);
                for(int i = dead.size()*4; i > 0; i--)
                {
                    if(dead.size() <= sick.size())
                    {
                        dead.add(i);
                        sick.remove(i);
                    }
                    else
                        break;
                }
            }
            System.out.println("Original population: " + population.size());
            System.out.println("Sick population: " + sick.size());
            System.out.println("Healthy population: " + healthy.size());
            System.out.println("Dead population: " + dead.size());
            //checkSick(); //Redundant?
        }
        else if(/*checkSick() && */!checkDead()) //Unnecessary
        {
            if(lethal >= 35)
            {
                for(int i = sick.size(); i > 0; i--)
                {
                    dead.add(i);
                }

                for(int j = sick.size(); j > 0; j--)
                {
                    sick.remove(j);
                }
            }
            else if(lethal < 12)
            {
                System.out.println("Lethality: " + lethal);
                for(int i = lethal*3; i > 0; i--)
                {
                    if(dead.size() <= sick.size())
                    {
                        dead.add(i);
                        sick.remove(i);
                    }
                    else
                        break;
                }
            }
            else
            {
                System.out.println("Lethality: " + lethal);
                for(int i = dead.size()*(lethal-10); i > 0; i--)
                {
                    if(dead.size() <= sick.size())
                    {
                        dead.add(i);
                        sick.remove(i);
                    }
                    else
                        break;
                }
            }
        }
        else if(checkDead())
        {
            System.out.println("Congratulations! You wiped out the population in... " + count + " days!");
        }
        count++;
    }

    public boolean checkSick()
    {
        if(totpop == sick.size())
            return true;
        else
            return false;
    }

    public boolean checkDead()
    {
        if(totpop == dead.size())
            return true;
        else
            return false;
    }

    public void Illinois()
    {
        for(int i = 0; i < 12800000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(12800000-1);
        sick.add(population.size());
        getPop(0, 0);
    }

    public void NewYork()
    {
        for(int i = 0; i < 8538000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(8538000-1);
        sick.add(population.size());
        getPop(0, 0);
    }

    public void MA()
    {
        for(int i = 0; i < 6812000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(6812000-1);
        sick.add(population.size());
        getPop(0, 0);
    }

    public void Florida()
    {
        for(int i = 0; i < 20610000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(20610000-1);
        sick.add(population.size());
        getPop(0, 0);
    }

    public void Nebraska()
    {
        for(int i = 0; i < 1907000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(1907000-1);
        sick.add(population.size());
        getPop(0, 0);
    }

    public void California()
    {
        for(int i = 0; i < 39250000; i++)
        {
            population.add(i);
            healthy.add(i);
            totpop++;
        }
        healthy.remove(39250000-1);
        sick.add(population.size());
        getPop(0, 0);
    }
}
