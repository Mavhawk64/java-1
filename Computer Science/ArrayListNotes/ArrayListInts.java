package ArrayListNotes;
import java.util.ArrayList;
public class ArrayListInts
{
    public static void main (String [] args)
    {
        ArrayList < Integer > numbers = new ArrayList < Integer > ();
        
        for(int i = 1; i < 10; i++)
        {
            numbers.add(i);
        }
        System.out.println(numbers);
        System.out.println(numbers.size());
        for(int i = 0; i < 3; i++)
        {
            numbers.remove(i);
        }
        System.out.println(numbers);
        System.out.println(numbers.isEmpty());
        System.out.println(numbers.size());
    }
}
