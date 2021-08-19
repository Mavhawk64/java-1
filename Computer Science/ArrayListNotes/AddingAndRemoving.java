package ArrayListNotes;
import java.util.ArrayList;

/**
 * Write a description of class f here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddingAndRemoving
{
    public static void main (String [] args)
    {
        String [] studentNames = new String[8];
        
        studentNames[0] = "John";
        studentNames[0] = "";
        studentNames[0] = null;
        studentNames[0] = "DNE";
        
        ArrayList <String> users = new ArrayList <String> ();
        users.add("John");
        users.add("Joe");
        users.add("Jill");
        users.add("Jan");
        
        System.out.println(users.size());
        System.out.println(users);
        users.remove("Joe");
        System.out.println(users.size());
        System.out.println(users);
        System.out.println(users.isEmpty());
        users.add(2, "Joe");
        users.set(2, "Juan");
    }
}
