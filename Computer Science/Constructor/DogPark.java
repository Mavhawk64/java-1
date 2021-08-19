package Constructor;

public class DogPark
{
    public static void main (String [] args)
    {
        Dog Chester = new Dog("Chester");
        Dog EB = new Dog("EliteBarbarians");
        Dog Sparky = new Dog("Sparky");
        Dog Nina = new Dog("Nina");
        Dog LumberJack = new Dog("LumberJack");
        System.out.println(Chester.name);
        System.out.println(EB.name);
        System.out.println(Sparky.name);
        System.out.println(Nina.name);
        System.out.println(LumberJack.name);
        Chester.speak();
        Chester.speak();
    }
}
