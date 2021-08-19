
/**
 * Write a description of class asm2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class asm2
{
    public static void main()
    {
        int a = 13; //Given left number converted from hex
        int b = 30; //Given right number converted from hex
        while(a <= 26536) //From line: <+31>:  cmp    DWORD PTR [ebp-0x8],0x67a8
        {
            b += 1; //From line: <+20>:  add    DWORD PTR [ebp-0x4],0x1
            a += 250; //From line: <+24>:  add    DWORD PTR [ebp-0x8],0xfa
        }
        System.out.println("B in Decimal is " + b);
    }
}
