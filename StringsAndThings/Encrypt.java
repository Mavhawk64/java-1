import java.util.Scanner;
/**
 * Write a description of class Encrypt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Encrypt
{
    public static String Encrypt (String msg)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to encrypt with Caesar or Vigenere?");
        String caevig = scan.nextLine();
        Encrypt e1 = new Encrypt();
        char z = 'a';
        char x = 'a';
        if(caevig.contains("c"))
        {
            e1.Caesar(msg, z);
        }
        else
        {
            e1.Vigenere(msg);
        }
        return msg;
    }
    //3mod2 = 1
    //Mod is dividing number 2 by number 1 and it returns the remainder, so 3mod2 = 1 (3/2 = 1r1)
    //When you mod a number lower than the second number, it will be that number...
    //11mod12 = 11
    //Mod divides 11/12 , so 0r11
    //To code it, do 3%2 = 1
    private static String Caesar (String msg, char z)
    {
        System.out.println("Please enter your secret message.");
        Scanner scan1 = new Scanner(System.in);
        msg = scan1.nextLine();
        System.out.println("Now, enter your key.(Number)");
        int key = scan1.nextInt();
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

    private static String Vigenere (String msg)
    {
        int i;
        Encrypt e1 = new Encrypt();
        char x;
        System.out.println("Please enter your secret message.");
        Scanner scan1 = new Scanner(System.in);
        msg = scan1.nextLine();
        System.out.println("Now, enter your key.(Word)");
        String key = scan1.nextLine();
        char [] keychar = key.toCharArray();
        int keynum = keychar.length;
        char [] vigenere = msg.toCharArray();
        for(i = 0; i < vigenere.length; i++)
        {
            //Vigenere[i] = ASCII 97 - 122
            int y = i%keynum;
            char z = key.charAt(y);
            x = msg.charAt(i);
            e1.Caesar(msg, z);
            System.out.print((char)y);
        }
        return msg;
    }

}
