package PolyAssignment;


/**
-Build me a simple Parent, Child, and Runner
-Upcast the Child method to the Parent
-Attempt to access Child methods through upcasted object
-Call a few of the parents methods through the upcasted object
-Try a few illegal casting maneuvers
-Finally perform a legal downcast
 */
public class Child extends Parent
{
    @Override
    public void noise(String sound)
    {
        sound = "I want cake";
        System.out.println(sound);
        this.eyeColor(eye);
    }

    @Override
    public void eyeColor(String eye)
    {
        super.eyeColor(eye);
    }
    
    @Override
    public void hairColor(String hair)
    {
        hair = "Blonde";
        System.out.println("My hair color is " + hair);
    }
}
