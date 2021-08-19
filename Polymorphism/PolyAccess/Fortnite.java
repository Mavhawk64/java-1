package PolyAccess;
import java.util.*;

/**
 * Write a description of class Fortnite here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fortnite extends VideoGames
{
    @Override
    public void Controls()
    {
        System.out.println("L3 to Sprint, Left Joystick Move, R3 Crouch, Right Joystick Camera, L2 Aim, R2 Shoot, X Jump, O Build, [] Reload, D-Up Inventory");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.equalsIgnoreCase("O"))
        {
            Build();
        }
    }
    
    public void Build()
    {
        System.out.println("Build a wall");
    }
}
