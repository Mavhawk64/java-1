import java.util.Scanner;
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caesar
{
    public static void Caesar (String [] args)
    {
        Caesar c1 = new Caesar();
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Would you like to encrypt or decrypt via Caesar or no?");
            Scanner scan1 = new Scanner(System.in);
            String continue1 = scan1.nextLine();
            String keyV = "";
            char [] keychar = keyV.toCharArray();
            int keynum = keychar.length;
            
            if(continue1.equalsIgnoreCase("encrypt") || continue1.equalsIgnoreCase("e"))
            {
                System.out.println("Please enter your secret message.");
                Scanner scan2 = new Scanner(System.in);
                String msg = scan1.nextLine();
                System.out.println("Now, enter your key.(Number)");
                int key = scan1.nextInt();
                c1.Encrypt(msg, key, keyV, keynum, keychar);
                i++;
            }
            else if(continue1.equalsIgnoreCase("decrypt") || continue1.equalsIgnoreCase("d"))
            {
                System.out.println("Please enter your secret message.");
                Scanner scan3 = new Scanner(System.in);
                String msg = scan1.nextLine();
                System.out.println("Now, enter your key.(Number)");
                int key = scan1.nextInt();
                c1.Decrypt(msg, key, keyV, keynum, keychar);
                i++;
            }
            else
            {
                System.out.println("OOPS, did you mean to say '" + continue1 + "'?");
                String quit = scan1.nextLine();
                if(quit.equalsIgnoreCase("Yes") || quit.contains("y"))
                {
                    System.err.println("Ending Program");
                    i++;
                }
                else
                {
                    System.out.println("Restarting Program");
                    i = 0;
                }
            }
        }      
    }

    public static String Encrypt (String msg, int key, String keyV, int keynum, char [] keychar)
    {
        char [] caesar = msg.toCharArray();
        int i = 0;
        for(i = 0; i < caesar.length; i++)
        {
            //caesar[i] = ASCII 97 - 122
            int y = caesar[i];
            y = y - 97;
            y = (y + key);
            y = (y)%(26);
            y = y + 97;
            System.out.print((char)y);
        }
        return msg;
    }

    public static String Decrypt (String msg, int key, String keyV, int keynum, char [] keychar)
    {
        char [] caesar = msg.toCharArray();
        int i = 0;
        for(i = 0; i < caesar.length; i++)
        {
            //caesar[i] = ASCII 97 - 122
            int y = caesar[i];
            y = y - 97;
            y = (y)%(26);
            y = (y - key);
            y = y + 97;
            System.out.print((char)y);
        }
        return msg;
    }
}
