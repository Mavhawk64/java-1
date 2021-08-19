import java.util.Scanner;
/**
 * Vigenere Cipher
 * Mav
 */
public class VigenereCipher
{
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toLowerCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z')
            {
                continue;
            }
            res += (char) ((c + key.charAt(j) - 2 * 'a') % 26 + 'a');
            j = ++j % key.length();
        }
        return res;
    }

    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toLowerCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'a' || c > 'z')
            {
                continue;
            }
            res += (char) ((c  - key.charAt(j) - 97) % (26 - 'a')+ 97 + 26);
            j = ++j % key.length();
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter your Secret message");
        String message = scan1.nextLine();
        System.out.println("Enter your key (Word)");
        String key = scan1.nextLine();
        System.out.println("Would you like to encrypt or decrypt?");
        String ans = scan1.nextLine();
        String encryptedMsg = encrypt(message, key);
        String decryptedMsg = decrypt(message, key);
        if(ans.contains("d") || ans.contains("decrypt"))
        {
            System.out.println("String: " + message);   
            System.out.println("Decrypted message: " + decryptedMsg);
        }
        else
        {
            System.out.println("String: " + message);
            System.out.println("Encrypted message: " + encryptedMsg);
        }

        
    }
}