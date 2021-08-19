package PolyAccess;

/**
 * Runner
 */
public class Playstation4 //Runner
{
    public static void main (String [] args)
    {
        System.out.println("--------Playstation 4--------");
        VideoGames g1 = new Fortnite(); //Legal upcasted
        //g1.Build(); It has been upcasted
        GrandTheftAuto GTA = new GrandTheftAuto();
        GTA.Controls();
        VideoGames g2 = (VideoGames)GTA;
        g2.Controls();
        VideoGames vg = new GrandTheftAuto();
        //GrandTheftAuto y1 = (GrandTheftAuto)GTA1;
        if(vg instanceof GrandTheftAuto)
        {
            GrandTheftAuto GTA2 = (GrandTheftAuto)vg;
            System.out.println("GTA?");
        }
        else if(vg instanceof Fortnite)
        {
            Fortnite f599 = (Fortnite)vg;
            System.out.println("FORTNITE?");
        }
        else if(vg instanceof VideoGames)
        {
            System.out.println("FAILED");
        }
        else
        {
            System.out.println("Huh...");
        }
    }
}
