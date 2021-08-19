/**
 * Converts number to binary and divides by 10, and prints out number in decimal
 * 255 >> 1 -d2b- 1111 1111 to 0111 1111 -b2d- 127
 * d2b = decimal to binary
 * b2d = binary to decimal
 */
public class BitTest
{
    public static void main (String [] args)
    {
        System.out.println(100 >> 2);
        System.out.println(100 << 2);
        System.out.println(255 >> 1);
        System.out.println(-1 >> 1); //bit -- keeps negative
        System.out.println(-1 >>> 1); //logical -- different because -1 in binary is (64 1's) 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111 1111
    }
}
