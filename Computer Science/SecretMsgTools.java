import java.util.Scanner;
public class SecretMsgTools
{
    public static void main ()
    {
        /**
         * The charAt
         */
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a three letter name:");
        String name = scan.nextLine();
        //imagine if "Mav" is entered
        char firstLetter = name.charAt(0);
        char secondLetter = name.charAt(1);
        char thirdLetter = name.charAt(2);
        System.out.println(firstLetter);
        System.out.println(secondLetter);
        System.out.println(thirdLetter);
        System.out.println("Please enter your name");
        String name2 = scan.nextLine();
        char [] letters = new char[name2.length()];
        System.out.println("This is your name vertically:");
        for(int i = 0; i < name2.length(); i++)
        {
            letters[i] = name2.charAt(i);
            System.out.println(letters[i]);
        }
        System.out.println("And horizontally, with *s in between each letter");
        for(int i = 0; i < letters.length; i++)
        {
            System.out.print(letters[i] + "*");
        }
        char [] alphabet = {'a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i = 0; i < 26; i++)
        {
            //if stuff
        }
        System.out.println("Decrypt or Encrypt?!?");
        String crypt = scan.nextLine();
        if(crypt.equalsIgnoreCase("decrypt"))
        {
            decrypt(name, alphabet, crypt);
        }
        
    }

    public static void decrypt(String name, char[] alphabet, String crypt)
    {
        char [] decrypt = new char[crypt.length()];
        for(int i = 0; i < crypt.length(); i++)
        {
            decrypt[i] = name.charAt(i);
            System.out.println(alphabet[i]);
        }
    }
}

