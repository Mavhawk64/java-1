import java.util.Scanner;
/**
 * I am Maverick Berkland, and I made this program from the resources of this semester and the key is for Fourth Period Computer Science.
 * Maverick Berkland
 * 14 March, 2017
 */
public class MaverickSecrets
{
    public static void main (String [] args)
    {
        char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' ','1','2','3','4','5','6','7','8','9','0'};
        char [] key =      {'p','h','e','d','t','z','c','v','l','i','u','y','j','k','g','m','r','w','b','a','o','x','s','q','f','n','%','?','@','$','<','&','+','!','#','9','='};
        Scanner scan1 = new Scanner(System.in);
        System.out.println("What is your secret message?");
        String secret = scan1.nextLine();
        secret = secret.toLowerCase();
        String message1 = "Whatever";
        message1 = message1.toLowerCase();
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Would you like to Encrypt or Decrypt the message?");
            Scanner scan = new Scanner(System.in);
            String message = scan.nextLine();
            if(message.equalsIgnoreCase("Encrypt"))
            {
                i++;
                encrypt(message,alphabet,key,secret);
            }
            else if(message.equalsIgnoreCase("Decrypt"))
            {
                i++;
                decrypt(message,alphabet,key,secret);
            }
            else
            {
                i--;
                System.out.println("TRY TO TYPE IT CORRECTLY!");
            }
        }
    }

    public static void encrypt (String message, char [] alphabet, char [] key, String secret)
    {
        char [] msg = new char [secret.length()];
        System.out.println("ENCRYPTING YOUR MESSAGE...");
        for(int i = 0; i < secret.length(); i++)
        {
            msg[i] = secret.charAt(i);
            for(int j = 0; j < alphabet.length; j++)
            {
                if(msg[i] == alphabet[j])
                {
                    System.out.print(key[j]);
                }
            }
        }
    }

    public static void decrypt (String message, char [] alphabet, char [] key, String secret)
    {
        char [] msg = new char [secret.length()];
        System.out.println("DECRYPTING YOUR MESSAGE...");
        for(int i = 0; i < secret.length(); i++)
        {
            msg[i] = secret.charAt(i);
            for(int j = 0; j < key.length; j++)
            {
                if(msg[i] == key[j])
                {
                    System.out.print(alphabet[j]);
                }
            }
        }    
    }
}
