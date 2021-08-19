public class HelloWorld
{
    public static void main(String[] args)
    {
        System.out.println("Hello World, my name is Maverick.");
        //int a will determine: if, else if, else
        int a=2;
        double b=6.982;
        String c="I've got a whole lot of money! I've got ";
        b=b*a;
        if (a>=2)
        {
        System.out.println(c + b);
        
    }
    else if (a==1)
    {
        System.out.println("I've got some money... " + b);
        
    }
    else
    {
        System.out.println("I'm broke");
    }
    
}
    }