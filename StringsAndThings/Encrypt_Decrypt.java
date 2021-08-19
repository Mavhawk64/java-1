import java.util.Scanner;
/**
 * Maverick Berkland
 * 19 September, 2017
 * Encrypting and Decrypting with Caesar and Vigener Cipher
 */
public class Encrypt_Decrypt
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 2; i++)
        {
            System.out.println("Would you like to encrypt or decrypt or no?");
            String continue1 = scan.nextLine();
            if(continue1.equalsIgnoreCase("encrypt") || continue1.equalsIgnoreCase("e"))
            {
                Encrypt e1 = new Encrypt();
                String msg="";
                e1.Encrypt(msg);
                i++;
            }
        }
    }
}
