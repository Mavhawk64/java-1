
public class Operations
{
    public static void main (String [ ] args)
    {
        System.out.println("Hello World");
        int x = 69;
        int y = 420;
        int z = 1738;
        int w = 21;
        int sum = x+y+z+w;
        System.out.println(sum);
        String name = "Maverick ";
        System.out.println(name);
        
        name = name + "cat";
        
        System.out.println(name);
        System.out.println("Jacobo es un traje de bano");
       int a=9;
       int b=4;
       //Can either print to screen or store in a variable
       System.out.println("The sum is " + a+b);
       int add=a+b;
       int diff=a-b;
       int mult=a*b;
       int div=a/b;
       System.out.println("The sum of a and b is " + add);
       System.out.println("The difference of a and b is " + diff);
       System.out.println("The product of a and b is " + mult);
       System.out.println("The quotient of a and b is " + div);
       System.out.println("JACOBO, IT IS MEME, NOT MeEm");
       //Nope, it's 0.0 because int division
       double quot2=4/9;
       System.out.println(quot2);
       //Avoid a law-suit, force ints to doubles
       double quot3=4.00/9.00;
       System.out.println("Correct decimal value: " + quot3);
       double c=4;
       double d=9;
       double quot4=c/d;
       System.out.println(quot4);
       System.out.println("Jacobo es mi amigo favorito");
       //This is new:
       //boolean is true/false statement
       //a 0 or 1 in memory
       boolean isAlive=true;
       boolean inMathClass=false;
       //This is also new
       //less space = more efficient
       char initial= 'm';
       char gender= 'm';
       System.out.println(isAlive);
       System.out.println(gender);
       
}
}

