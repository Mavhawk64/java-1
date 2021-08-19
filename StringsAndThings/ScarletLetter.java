import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Maverick Berkland
 * Writing ScarletLetter
 * 14 September, 2017
 */
public class ScarletLetter
{
    public static void main (String [] args)
    {
        File file = new File("ScarletLetter.txt");
        try
        {
            Scanner scan = new Scanner(file);
            PrintWriter write = new PrintWriter("NewScarlet.txt" , "UTF-8");
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                line = line.replace("Hester Prynne", "Jimmy John's");
                line = line.replace("Hester", "Jimmy John's");
                System.out.println(line);
                write.println(line);
            }
        }
        catch(Exception error)
        {
            System.err.println("HEY THE ERROR IS: " + error);
        }
        
    }
}
