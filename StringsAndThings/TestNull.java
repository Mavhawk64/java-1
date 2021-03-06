import java.util.Random;
/**
 * Learning about null
 * 
 * Maverick Berkland 
 * 10 October, 2017
 */
public class TestNull
{
    public static void main (String [] args)
    {
        /**
         * Null means no Data and
         * can only be used for object data.
         * Null is used for the explicit declaration
         * of an object with no memory.
         * 
         * Primitive data (int) cannot have the value of null
         */
        //So small that you don't really need to state "no data"
        boolean choice = true; //1 bit
        char letter = 'a'; //1 byte or 8 bits
        int x = 324; //minimal data allocated as well

        //I know type and name, but it doesn't exist
        Random r1 = null;

        //No memory allocated
        //Explicitly left null
        //There was no data entered, no name was entered
        String name = null;
        //Same thing, but don't know if this one is accident or what...
        String name1;

        //These two are the same also!!!
        //Empty Strings
        //The person doesn't have a name
        String name2 = new String();
        String name3 = "";
        
        //This has a value of space which is an ASCII value
        String name4 = " ";
        
        String test = name; //Test is set to the value null
        String test2 = name + "hello"; //Add something with no memory, and add it to some memory (hello), to get hello

        //NULL Pointer Exception
        //Cannot access or call 'no memory'
        String str1 = null;
        String str2 = "test";
        /**
        if(str1.equals(str2))
        {
        System.out.println("Works?");
        }
        else
        {
        System.out.println("FAILS");
        }
         */

        String str3 = "";
        String str4 = new String();

        if(str3.equals(str4))
        {
            System.out.println("WORKS");
        }
        else
        {
            System.out.println("FAILS");
        }
        
        
    }
}
