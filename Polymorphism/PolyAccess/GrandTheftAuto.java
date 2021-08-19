package PolyAccess;
import java.util.*;

/**
 * Write a description of class GrandTheftAuto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrandTheftAuto extends VideoGames
{
    String gun = "";
    Scanner scan = new Scanner(System.in);
    @Override
    public void Controls()
    {
        System.out.println("L3 to Crouch, Left Joystick Move, R3 Zoom, Right Joystick Camera, L2 Aim, R2 Shoot, X Run/Sprint, O Reload, [] Jump, /\\ Get in Car, L1 Choose Gun, R1 (in car) Handbreak, R1 Hide/Take Cover Behind Wall, D-Left (in car) Radio, D-Up Phone, D-Down Zoom Map, D-Down (hold) SWAP Character, D-Right (in vehicle) Headlights, [] (in vehicle) Change Weapon, Big Middle Button - POV, Options - Open Map/Pause Menu, Share - Send Screenshot/Video");
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("/\\"))
        {
            Drive();
        }
        else if(input.equalsIgnoreCase("L1"))
        {
            gunChoose();
        }
        else if(input.equalsIgnoreCase("L2"))
        {
            Shoot();
        }
        else if(input.equalsIgnoreCase("hold D-Down"))
        {
            Character();
        }
        else if(input.equalsIgnoreCase("[]"))
        {
            Jump();
        }
    }
    
    public void Jump()
    {
        System.out.println("*Jumps*");
    }

    public void Drive()
    {
        System.out.println("Vroom!");
    }

    public void gunChoose()
    {
        System.out.println("Choose gun...");
        gun = scan.nextLine();
        Controls();
    }

    public void Shoot()
    {
        System.out.println("Chick Chick - BOOM");
    }

    private void Character()
    {
        System.out.println("---Character Stats---");
        double height = 6.2;
        System.out.println("Height: " + height + " feet tall");
        String hair = "Brown";
        System.out.println("Hair color: " + hair);
        String eye = "Purple";
        System.out.println("Eye color: " + eye);
        int weight = 145;
        System.out.println("Weight: " + weight + " lbs.");
        int strength = 100;
        System.out.println("Strength: " + strength);
        int drive = 100;
        System.out.println("Driving: " + drive);
        int stealth = 90;
        System.out.println("Stealth: " + stealth);
        int level = 278;
        System.out.println("Level: " + level);
        long RP = 92038749;
        System.out.println("RP: " + RP + "/100000000");
    }
}
