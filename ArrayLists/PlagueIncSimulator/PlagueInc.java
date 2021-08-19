package PlagueIncSimulator;
import java.util.*;
/**
 * Write a description of class DiseaseRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlagueInc
{
    public static void main (String [] args)
    {
        System.out.println("------Plague Inc.------");
        System.out.println("Choose a Disease");
        System.out.println("A. Bacteria");
        System.out.println("B. Virus");
        System.out.println("C. Parasite");
        System.out.println("D. Fungus");
        System.out.println("E. Prion");
        System.out.println("F. Nano-Virus");
        System.out.println("G. Bio-Weapon");
        Scanner c = new Scanner(System.in);
        String x = c.nextLine();
        x = x.toLowerCase();
        if(x.contains("a"))
        {
            Bacteria b1 = new Bacteria();
        }
        else if(x.contains("b"))
        {
            Virus v1 = new Virus();
        }
        else if(x.contains("c"))
        {
            Parasite p1 = new Parasite();
        }
        else if(x.contains("d"))
        {
            Fungus f1 = new Fungus();
        }
        else if(x.contains("e"))
        {
            Prion pr1 = new Prion();
        }
        else if(x.contains("f"))
        {
            NanoVirus n1 = new NanoVirus();
        }
        else if(x.contains("g"))
        {
            BioWeapon bw1 = new BioWeapon();
        }
    }
}
