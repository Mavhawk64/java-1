package PolyAssignment;

/**
 * -Build me a simple Parent, Child, and Runner
-Upcast the Child method to the Parent
-Attempt to access Child methods through upcasted object
-Call a few of the parents methods through the upcasted object
-Try a few illegal casting maneuvers
-Finally perform a legal downcast
 */
public class Parent
{
    //Attributes
    String sound = "Eat your Broccoli!";
    String eye = "Green";
    String hair = "Brown";
    
    /*Parent()
    {
        noise(sound);
        eyeColor(eye);
        hairColor(hair);
    }
    */
    String io = "WHAT";
    
    public void noise(String sound)
    {
        System.out.println(sound);
    }

    public void eyeColor(String eye)
    {
        System.out.println("My eyes are " + eye);
    }
    
    public void hairColor(String hair)
    {
        System.out.println("My hair color is " + hair);
    }
}
