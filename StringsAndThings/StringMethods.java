
/**
 * Maverick Berkland
 * Learning More About Strings
 * 30 August, 2017
 */
public class StringMethods
{
    //Ten String Methods for homework
    public static void main (String [] args)
    {
        String test = "London bridge is falling down";
        int x = test.indexOf("b");
        System.out.println("1. " +x);
        String test1 = "ajdskluif";
        int y = test1.indexOf("m");
        System.out.println("2. " + y);
        String str = "abc";
        String ing = "def";
        String g = str.concat(ing);
        System.out.println("3." + g);
        int h = ing.compareTo(str);
        System.out.println("4. " + h);
        String regex = "regex";
        String reflex = "reflex";
        boolean i = reflex.matches(regex);
        System.out.println("5. " + i + ", " + regex + " does not equal " + reflex);
        int len = test1.length();
        System.out.println("6. " + len);
        String intern = test1.intern();
        System.out.println("7 " + intern);
        boolean emp = test1.isEmpty();
        System.out.println("8. " + emp + " is not empty, it has " + len + " letters");
        String rep = ing.replaceAll(ing, regex);
        System.out.println("9. " + rep);
        String mess = "sweet, sugary, spiderman candies are delicious!";
        String rep1 = mess.replace("s", "$");
        System.out.println("10. " + rep1);
        
        //AP Exam String Methods
        
        
        int mystery = test.indexOf(test.charAt(5));
        System.out.println(mystery);
        
        String userPass1 = "CloneMan/NE35123";
        
        //  string.substring(start , end + 1)
        String username = userPass1.substring(5,8);
        System.out.println(username);
        
        
        String username2 = userPass1.substring(0 , userPass1.indexOf("/"));
        System.out.println(username2);
        String password = userPass1.substring(userPass1.indexOf("/" + 1, userPass1.length()));
        System.out.println(password);
        
        
    }
}
