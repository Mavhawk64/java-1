package Doggo;
import java.util.Scanner;
public class DogPark
{
    public static void main (String [] args)
    {
        Dog d1 = new Dog();
        System.out.println("The first dog has a tail: " + d1.tail);
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the breed of your dog.");
        String type = scan.nextLine();
        System.out.println("Enter the fur color of your dog.");
        String color = scan.nextLine();
        System.out.println("Enter the name of your dog.");
        String name = scan.nextLine();
        //Second dog created 
        Dog d2 = new Dog(type, color, name);

        //Getter and Setter Test
        d2.setName(name);
        d2.setColor(color);
        d2.setBreed(type);
        System.out.println("Dog #" + /**To Call static variables, you have to call the class (Dog)*/ Dog.dogPopulation +  ", " + d2.getName() + ", is a(n) " + d2.getColor() + " " + d2.getBreed());

        //Method Overload Test
        d1.makeSound();
        d2.makeSound("Ruff");
        
        String [] dogNames = {"Bones","Rex","Fluffy"};
        for(int i = 0; i < dogNames.length; i++)
        {
            System.out.println(dogNames[i]);
        }
        String dog3 = "Bones";
        String dog4 = "Rex";
        String dog5 = "Fluffy";
        Dog d3 = new Dog(dog3);
        Dog d4 = new Dog(dog4);
        Dog d5 = new Dog(dog5);
        System.out.println("There are " + Dog.dogPopulation + " dogs now.");
        int health = 100;
        d3.makeSound("Growl");
        System.out.println("UH OH! " + dog3 + " walks up and wants to fight " + name + "!");
        System.out.println(name + " accepts the challenge...");
        System.out.println(name + " attacks first");
        System.out.println(dog3 + "'s health is " + d3.getHealth());
        System.out.println(dog3 + " attacks!");
        System.out.println("OH NO! " + name + "'s health is now at " + d2.getHealth());
        System.out.println(name + " gets back up and defeats " + dog3);
        System.out.println(dog3 + "'s health is " + d3.getHealth());
        System.out.println("There are now " + Dog.dogPopulation + " dogs left");
        
        String x = "hello";
        if(x.equals("hello"))
        {
            System.out.println("EQUAL");
        }
    }
}