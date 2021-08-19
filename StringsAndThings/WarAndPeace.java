import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
/**
 * Maverick Berkland
 * WAR AND PEACE
 * 15 September, 2017
 */
public class WarAndPeace
{
    public static void main (String [] args)
    {
        File file = new File("WarAndPeace.txt");
        try
        {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine())
            {
                String line = scan.nextLine();
                line = line.toUpperCase();
                line = line.replace("WAR", "COMMUNIST PROPAGANDA");
                line = line.replace("PEACE", "STUPID PEOPLE");
                System.out.println(line);
            }
        }
        catch(Exception error)
        {
            System.err.println("HEY THE ERROR IS: " + error);
        }
    }
}