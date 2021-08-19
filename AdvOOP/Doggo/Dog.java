package Doggo;
import java.util.Random;
/**
 * A class is a blueprint where many objects can be created.
 * Encapsulation:
 * The idea of being mindful of access.
 * Logically controlling the access of carious components of your program in a meaningful way.
 * Identifying the important parts and putting them "in a capsule".
 */
public class Dog
{
    //Attributes
    //C++ calls these Global variables
    //Java calls these Instance Variables
    //These Instance/Global Variables are outside of methods, and may be accessed by methods within this class

    //ACCESS Modifiers: public, private
    //Scope refers to the visibility/accessibility of the variable(s)
    public  boolean tail;
    private String  breed;
    private String  furColor;
    private String  dogName; //Needs to be private most of the time
    private int health = 100;
    //Static is 1 of that variable ie population
    //public static long population = 915,000;
    //private int health;
    //You can change health to a certain person (Method) ie public void Maverick(int health) {}
    public static int dogPopulation = 0;

    //Constructors - Always the same name as the class
    //Standard dog - No breed, color, name    
    Dog()
    {
        tail = true;
        breed = "";
        furColor = "";
        dogName = "";
        dogPopulation++;
        this.health = health;
    }
    
    Dog(String dogName)
    {
        tail = true;
        this.dogName = dogName;
        dogPopulation++;
        this.health = health;
    }
    
    //Different dog
    Dog(String breed, String furColor, String dogName)
    {
        tail = true;
        //this refers to THIS Dog class attributes
        this.breed = breed;
        this.furColor = furColor;
        this.dogName = dogName;
        dogPopulation++;
    }
    
    //Behaviors
    //Java: Methods
    //Other Languages: Functions

    //Method OVERLOAD
    public void makeSound()
    {
        System.out.println("Woof, Baby, Woof!!!");
    }

    public void makeSound(String sound)
    {
        System.out.println(sound);
    }
    
    public void minusHP(int health)
    {
        this.health = health;
        health-=50;
        if(health == 0)
        System.out.println("Dead");
    }
    
    //Getter
    /**
     * A Getter
     * -Always Returns
     * -Always Public
     * Note: All of this because name is private
     * @return String dogName
     */
    public String getName ()
    {
        return this.dogName;
    }
    
    //Setter
    /**
     * A Setter 
     * -Always Public
     * -Always Void
     * @param String dogName
     */
    public void setName (String dogName)
    {
        this.dogName = dogName;
    }
    
    //Getter
    /**
     * A Getter
     * -Always Returns
     * -Always Public
     * Note: All of this because name is private
     * @return String furColor
     */
    public String getColor ()
    {
        return this.furColor;
    }
    
    //Setter
    /**
     * A Setter 
     * -Always Public
     * -Always Void
     * @param String furColor
     */
    public void setColor (String furColor)
    {
        this.furColor = furColor;
    }
    
    //Getter
    /**
     * A Getter
     * -Always Returns
     * -Always Public
     * Note: All of this because name is private
     * @return String breed
     */
    public String getBreed ()
    {
        return this.breed;
    }
    
    //Setter
    /**
     * A Setter 
     * -Always Public
     * -Always Void
     * @param String breed
     */
    public void setBreed (String breed)
    {
        this.breed = breed;
    }
    
    //Getter
    public int getHealth()
    {
        return this.health;
    }
    
    //Setter
    //At Top minusHP(health)
    //Static Method for losing population
    /**
     * Static methods affect static variables
     * Static things belong to the class but not any one specific object
     * They belong to the general idea
     * There is only one copy of a static var/method across all objects
     */
    public static void minusPop()
    {
        dogPopulation--;
    }
}
