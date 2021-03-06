
/**
 * Test Tomorrow (Friday the 13th)
 * 10 True/False
 * 6 AP Multiple Choice
 * 6 Guess the Output
 * Write a Simple Program
 */
public class StringReview
{
    public static void main (String [] args)
    {
        int x = 5;
        if(x > 3)
            System.out.println("x is greater than 3");

        /**
         * 2 NULL questions on test!!!
         * 
         * Strings are objects
         * Therefore, we can run methods on them
         * And we can set Strings to NULL
         * We cannot run methods on primitive data
         */
        int [] nums = new int[5];
        String TheNumbers = nums.toString();
        System.out.println(TheNumbers);
        int y = 9;
        //String nine = y.toString();
        /**
         * Strings are immutable
         */
        String test = "Hello";
        String test2 = new String("Hello");
        if(test == test2)
        {
            System.out.println("YES THEY ARE THE SAME!");
        }
        else
        {
            System.out.println("NO!");
        }
        String test3 = "Hello";
        String test4 = new String("Hello");
        if(test3.equals(test4))
        {
            System.out.println("YES THEY ARE THE SAME!");
        }
        else
        {
            System.out.println("NO!");
        }
        
        /**
         * 5 String Methods that are common on the AP Test
         * 
         * .charAt();
         * .indexOf();
         * .substring(int , int);
         * .contains(String)
         * .equals(String)
         */
        
        String state = "Mississippi";
        int what = state.indexOf("iss");
        System.out.println(what);
        
        String StateLetter = state.substring(3,6);
        System.out.println(StateLetter);
        String mystery2 = state.substring(7);
        System.out.println(mystery2);
        
        String mystery3 = "jhgfdsajkslfjskldjfalsekfaklfjaieojfsoija";
        System.out.println((mystery3.contains("false")));
        //.contains() is a boolean!
        
        String mys = state.substring(state.indexOf(state.substring(4 , 8)), state.indexOf(state.charAt(6)));
        System.out.println(mys);
    }
}
