package Test;
public class Protect
{
    public static void main (String [] args)
    {
        /**
         * If we imported the package that class Dog belongs to, then we could make a new object and access vars / methods.
         * Just like the Scanner class.
         * However, that seemingly unlimited access is restricted with the access modifier: protected
         */
        System.out.println("Dog d1 = new Dog();");
    }
}
