
/**
 * Maverick Berkland
 * Strings are Objects?
 * 29 August, 2017
 */
public class StringsAreObjects
{
    public static void main (String [] args)
    {
        //Primitive Data
        
        int x = 9;
        x = x - 9;
        x = 8;
        
        //Object Data
        int [] testArray = new int [5];
        //Prints an address to where the array is located
        System.out.println(testArray);
        int y = testArray.length;
        
        //Strings ARE Objects
        
        String name = "Jan"; //Short cut syntax
        
        //Yes, there is Array Documentation
        //Yes, there is a reason you would want to declare like this
        String name2 = new String("Jon");
        
        name2 = "JeFf";
        
        name2 = name2.toLowerCase();
        
        System.out.println(name2);
        
        //Strings are Immutable
        
        String one = new String("Hello");
        String two = new String("Hello");
        System.out.println("EXAMPLE 1");
        //Says NO because the memory address (EXAMPLE: l![@fjkl) doesn't equal the other address
        if(one == two)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        
        String one1 = "Hello";
        String two2 = "Hello";
        System.out.println("EXAMPLE 2");
        //Says YES because the memory address is tought as primitive, making one address instead of two
        if(one1 == two2)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        //NEVER USE ==, USE .equals
        
        String one2 = new String("Hello");
        String two3 = new String("Hello");
        System.out.println("EXAMPLE 3");
        
        if(one2.equals(two3))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        
        String one3 = "Hello";
        String two4 = "Hello";
        System.out.println("EXAMPLE 4");
        
        if(one3.equals(two4))
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
        
        String a = new String("Cat");
        String b = new String("Dog");
        String c = new String("Pig");
        a = b;
        b = c;
        c = b;
        
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(c == b);
    }
}
